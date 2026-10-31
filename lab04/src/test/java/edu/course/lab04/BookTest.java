package edu.course.lab04;

import java.util.HashMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void equalBooksFindSameValue() {
        Book a = new Book("123", "Java");
        Book b = new Book("123", "Python");

        HashMap<Book, String> map = new HashMap<>();
        map.put(a, "Book found");

        assertNotSame(a, b);
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
        assertEquals("Book found", map.get(b));
    }

    @Test
    void differentIsbnBooksAreNotEqual() {
        Book a = new Book("123", "Java");
        Book b = new Book("456", "Java");

        assertNotEquals(a, b);
    }

    @Test
    void sameIsbnReplacesValue() {
        Book a = new Book("123", "Java");
        Book b = new Book("123", "Python");

        HashMap<Book, String> map = new HashMap<>();

        map.put(a, "First");
        map.put(b, "Second");

        assertEquals(1, map.size());
        assertEquals("Second", map.get(a));
    }

    @Test
    void equalsHandlesNullAndOtherTypes() {
        Book book = new Book("123", "Java");

        assertFalse(book.equals(null));
        assertFalse(book.equals("123"));
        assertEquals(book, book);
    }
}
