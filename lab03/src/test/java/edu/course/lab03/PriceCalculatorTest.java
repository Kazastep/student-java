package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PriceCalculatorTest {

    @Test
    void testCalculatorWithNoDiscount() {
        DiscountPolicy policy = new NoDiscount();
        PriceCalculator calculator = new PriceCalculator(policy);

        assertEquals(100.0, calculator.calculate(100.0));
    }

    @Test
    void testCalculatorWithPercentDiscount() {
        DiscountPolicy policy = new PercentDiscount(20);
        PriceCalculator calculator = new PriceCalculator(policy);

        assertEquals(80.0, calculator.calculate(100.0));
    }

    @Test
    void testPolicyReplacement() {
        double price = 200.0;

        PriceCalculator calculator1 =
            new PriceCalculator(new NoDiscount());

        PriceCalculator calculator2 =
            new PriceCalculator(new PercentDiscount(25));

        assertEquals(200.0, calculator1.calculate(price));
        assertEquals(150.0, calculator2.calculate(price));
    }

    @Test
    void testNegativePrice() {
        PriceCalculator calculator =
            new PriceCalculator(new PercentDiscount(20));

        assertThrows(IllegalArgumentException.class,
            () -> calculator.calculate(-100.0));
    }
}
