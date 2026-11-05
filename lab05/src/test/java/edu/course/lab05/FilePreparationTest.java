package edu.course.lab05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilePreparationTest {

    @TempDir
    Path tempDir;

    @Test
    void testReadFile() throws IOException {
        Path path = tempDir.resolve("text.txt");

        List <String> arr = List.of("10","bad","20");

        Path file = Files.write(path, arr, StandardCharsets.UTF_8);

        List<String> lines = Files.readAllLines(
                            path,
                            StandardCharsets.UTF_8
                        );
        assertEquals(arr, lines);

        List <Integer> nums = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            String line;

            while ((line = reader.readLine()) != null) {
               try {int num = Integer.parseInt(line);
                nums.add(num);
                } catch (NumberFormatException e){
                    
                }
            }
            assertEquals(List.of(10, 20), nums);
        }
    }

    @Test
    void testInvalidNumber() {
        assertThrows(
            NumberFormatException.class,
            () -> Integer.parseInt("bad")
        );
    }
}