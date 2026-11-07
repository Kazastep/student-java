
package edu.course.lab05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SampleFileLoaderTest {

    @TempDir
    Path tempDir;

    private static final String HEADER =
            "id;label;source;featureCount;status";

    // Создание временного UTF-8-файла для тестов
    private Path createFile(String... rows) throws IOException {
        Path path = tempDir.resolve("samples.txt");

        Files.write(
                path,
                List.of(rows),
                StandardCharsets.UTF_8
        );

        return path;
    }

    // 1. Корректный файл
    @Test
    void testValidFile() throws IOException {
        Path path = createFile(
                HEADER,
                "S-101;cat;camera-1;128;READY",
                "S-102;dog;camera-2;64;NEW"
        );

        LoadResult result = new SampleFileLoader().load(path);

        assertEquals(2, result.getSamples().size());
        assertTrue(result.getErrors().isEmpty());

        DataSample sample = result.getSamples().get(0);

        assertEquals("S-101", sample.getId());
        assertEquals("cat", sample.getLabel());
        assertEquals("camera-1", sample.getSource());
        assertEquals(128, sample.getFeatureCount());
        assertEquals(SampleStatus.READY, sample.getStatus());
    }

    // 2. Unicode и кириллица
    @Test
    void testUnicode() throws IOException {
        Path path = createFile(
                HEADER,
                "S-101;Кошка;камера-1;128;READY"
        );

        LoadResult result = new SampleFileLoader().load(path);

        assertEquals(1, result.getSamples().size());
        assertTrue(result.getErrors().isEmpty());
        assertEquals(
                "Кошка",
                result.getSamples().get(0).getLabel()
        );
        assertEquals(
                "камера-1",
                result.getSamples().get(0).getSource()
        );
    }

    // 3. Пустое поле
    @Test
    void testBlankField() throws IOException {
        Path path = createFile(
                HEADER,
                "S-101;;camera-1;128;READY"
        );

        LoadResult result = new SampleFileLoader().load(path);

        assertTrue(result.getSamples().isEmpty());
        assertEquals(1, result.getErrors().size());
        assertEquals(2, result.getErrors().get(0).getLineNumber());
        assertEquals("label", result.getErrors().get(0).getField());
    }

    // 4. Неправильное число
    @Test
    void testInvalidNumber() throws IOException {
        Path path = createFile(
                HEADER,
                "S-101;cat;camera-1;abc;READY"
        );

        LoadResult result = new SampleFileLoader().load(path);

        assertTrue(result.getSamples().isEmpty());
        assertEquals(1, result.getErrors().size());
        assertEquals(
                "featureCount",
                result.getErrors().get(0).getField()
        );
    }

    // 5. Неизвестный статус
    @Test
    void testInvalidStatus() throws IOException {
        Path path = createFile(
                HEADER,
                "S-101;cat;camera-1;128;UNKNOWN"
        );

        LoadResult result = new SampleFileLoader().load(path);

        assertTrue(result.getSamples().isEmpty());
        assertEquals(1, result.getErrors().size());
        assertEquals(
                "status",
                result.getErrors().get(0).getField()
        );
    }

    // 6. Неправильное количество столбцов
    @Test
    void testInvalidColumnCount() throws IOException {
        Path path = createFile(
                HEADER,
                "S-101;cat;128;READY"
        );

        LoadResult result = new SampleFileLoader().load(path);

        assertTrue(result.getSamples().isEmpty());
        assertEquals(1, result.getErrors().size());
        assertEquals(
                "fields",
                result.getErrors().get(0).getField()
        );
    }

    // 7. Корректные и ошибочные строки вместе
    @Test
    void testMixedRows() throws IOException {
        Path path = createFile(
                HEADER,
                "S-101;cat;camera-1;128;READY",
                "S-102;dog;camera-2;bad;READY",
                "S-103;bird;camera-3;64;NEW"
        );

        LoadResult result = new SampleFileLoader().load(path);

        assertEquals(2, result.getSamples().size());
        assertEquals(1, result.getErrors().size());

        assertEquals("S-101", result.getSamples().get(0).getId());
        assertEquals("S-103", result.getSamples().get(1).getId());
        assertEquals(3, result.getErrors().get(0).getLineNumber());
    }

    // 8. Отсутствующий файл
    @Test
    void testMissingFile() {
        Path path = tempDir.resolve("missing.txt");

        DataLoadingException exception = assertThrows(
                DataLoadingException.class,
                () -> new SampleFileLoader().load(path)
        );

        assertNotNull(exception.getCause());
        assertInstanceOf(IOException.class, exception.getCause());
    }

    // 9. Неправильный заголовок
    @Test
    void testInvalidHeader() throws IOException {
        Path path = createFile(
                "wrong;header",
                "S-101;cat;camera-1;128;READY"
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new SampleFileLoader().load(path)
        );
    }

    // 10. Неположительный featureCount
    @Test
    void testZeroFeatureCount() throws IOException {
        Path path = createFile(
                HEADER,
                "S-101;cat;camera-1;0;READY"
        );

        LoadResult result = new SampleFileLoader().load(path);

        assertTrue(result.getSamples().isEmpty());
        assertEquals(1, result.getErrors().size());
        assertEquals(
                "featureCount",
                result.getErrors().get(0).getField()
        );
    }
}
