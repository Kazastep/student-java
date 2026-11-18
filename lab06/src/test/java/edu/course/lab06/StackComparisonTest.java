package edu.course.lab06;

import org.junit.jupiter.api.Test;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StackComparisonTest {

    @Test
    void testLifoBehavior() {
        Stack<Integer> stack = new Stack<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int value : new int[]{10, 20, 30}) {
            stack.push(value);
            deque.push(value);
        }

        assertEquals(stack.pop(), deque.pop());
        assertEquals(stack.pop(), deque.pop());
        assertEquals(stack.pop(), deque.pop());

        assertTrue(stack.isEmpty());
        assertTrue(deque.isEmpty());
    }

    @Test
    void testEmptyBehavior() {
        Stack<Integer> stack = new Stack<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        assertThrows(NoSuchElementException.class, stack::pop);
        assertThrows(NoSuchElementException.class, deque::pop);

        assertThrows(NoSuchElementException.class, stack::peek);
        assertNull(deque.peek());
    }
}