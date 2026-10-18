package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PercentDiscountTest {

    @Test
    void testPercentDiscount() {
        DiscountPolicy policy = new PercentDiscount(20);
        assertEquals(80.0, policy.apply(100.0));
    }

    @Test
    void testFullDiscount() {
        DiscountPolicy policy = new PercentDiscount(100);
        assertEquals(0.0, policy.apply(100.0));
    }

    @Test
    void testZeroDiscount() {
        DiscountPolicy policy = new PercentDiscount(0);
        assertEquals(100.0, policy.apply(100.0));
    }

    @Test
    void testInvalidPercent() {
        assertThrows(IllegalArgumentException.class,
            () -> new PercentDiscount(120));
        assertThrows(IllegalArgumentException.class,
            () -> new PercentDiscount(-10));
    }

    @Test
    void testNegativePrice() {
        DiscountPolicy policy = new PercentDiscount(20);
        assertThrows(IllegalArgumentException.class,
            () -> policy.apply(-100.0));
    }
}
