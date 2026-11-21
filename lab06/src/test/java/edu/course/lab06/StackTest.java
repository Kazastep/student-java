
package edu.course.lab06;

import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void testEmptyStack() {
        Stack<Integer> stack = new Stack<>();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    void testPush() {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);

        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());
    }

    @Test
    void testPeek() {
        Stack<String> stack = new Stack<>();

        stack.push("Hello");
        stack.push("World");

        assertEquals("World", stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    void testPop() {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());

        assertTrue(stack.isEmpty());
    }

    @Test
    void testPushNull() {
        Stack<String> stack = new Stack<>();

        assertThrows(
            IllegalArgumentException.class,
            () -> stack.push(null)
        );

        assertTrue(stack.isEmpty());
    }

    @Test
    void testPopEmpty() {
        Stack<Integer> stack = new Stack<>();

        assertThrows(
            NoSuchElementException.class,
            () -> stack.pop()
        );
    }

    @Test
    void testPeekEmpty() {
        Stack<Integer> stack = new Stack<>();

        assertThrows(
            NoSuchElementException.class,
            () -> stack.peek()
        );
    }
}
