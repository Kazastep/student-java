package edu.course.lab06;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BoxTest {

    @Test
    void testStringBox() {
        Box<String> box = new Box<>("Hello");

        assertEquals("Hello", box.getValue());

        box.setValue("World");
        // box.setValue(100); // Ошибка компиляции: ожидается String, а не int.

        assertEquals("World", box.getValue());
    }

    @Test
    void testIntegerBox() {
        Box<Integer> box = new Box<>(10);

        assertEquals(10, box.getValue());

        box.setValue(20);

        assertEquals(20, box.getValue());
    }
}