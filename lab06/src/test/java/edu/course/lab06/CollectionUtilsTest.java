
package edu.course.lab06;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectionUtilsTest {

    @Test
    void testCopyIntegersToNumbers() {
        List<Integer> source = List.of(10, 20, 30);
        List<Number> destination = new ArrayList<>();

        CollectionUtils.copyAll(source, destination);

        assertEquals(List.of(10, 20, 30), destination);
    }

    @Test
    void testCopyStrings() {
        List<String> source = List.of("Alex", "Max");
        List<String> destination = new ArrayList<>();

        CollectionUtils.copyAll(source, destination);

        assertEquals(List.of("Alex", "Max"), destination);
    }

    @Test
    void testCopyIntegersToObjects() {
        List<Integer> source = List.of(1, 2, 3);
        List<Object> destination = new ArrayList<>();

        CollectionUtils.copyAll(source, destination);

        assertEquals(List.of(1, 2, 3), destination);
    }

    @Test
    void testDestinationKeepsExistingElements() {
        List<Integer> source = List.of(20, 30);
        List<Number> destination = new ArrayList<>();

        destination.add(10);

        CollectionUtils.copyAll(source, destination);

        assertEquals(List.of(10, 20, 30), destination);
    }

    @Test
    void testEmptySource() {
        List<Integer> source = List.of();
        List<Number> destination = new ArrayList<>();

        CollectionUtils.copyAll(source, destination);

        assertTrue(destination.isEmpty());
    }

    @Test
    void testSourceIsNotModified() {
        List<Integer> source = new ArrayList<>(
            List.of(10, 20, 30)
        );
        List<Number> destination = new ArrayList<>();

        CollectionUtils.copyAll(source, destination);

        assertEquals(List.of(10, 20, 30), source);
        assertEquals(List.of(10, 20, 30), destination);
    }
}
