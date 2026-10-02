package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SampleIdTest {

    // Тест проверяет инициализацию нового объекта
    @Test
    public void createsValidSampleId() {
        SampleId id = new SampleId("first");

        assertEquals("first", id.value());
    }

    // Тест проверяет равенство двух объектов SampleId по значению
    @Test
    public void equalSampleIds() {
        SampleId id1 = new SampleId("first");
        SampleId id2 = new SampleId("first");

        assertEquals(id1, id2);
    }

    // Тест проверяет ошибку при передаче null
    @Test
    public void throwsExceptionForNullId() {
        assertThrows(IllegalArgumentException.class,
            () -> new SampleId(null));
    }

    // Тест проверяет ошибку при передаче пустой строки
    @Test
    public void throwsExceptionForEmptyId() {
        assertThrows(IllegalArgumentException.class,
            () -> new SampleId(""));
    }
}