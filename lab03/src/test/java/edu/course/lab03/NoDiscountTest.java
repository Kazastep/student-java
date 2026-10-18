package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NoDiscountTest {

    @Test
    void testNoDiscount() {
        DiscountPolicy policy = new NoDiscount();
        assertEquals(100.0, policy.apply(100.0));
    }

    @Test
    void testZeroPrice() {
        DiscountPolicy policy = new NoDiscount();
        assertEquals(0.0, policy.apply(0.0));
    }

    @Test
    void testNegativePrice() {
        DiscountPolicy policy = new NoDiscount();
        assertThrows(IllegalArgumentException.class,
            () -> policy.apply(-100.0));
    }
}
