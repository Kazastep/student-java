package edu.course.lab01;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseToolkitTest {

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }

    @Test
    void returnsTrueForZero() {
        boolean result = CourseToolkit.isEven(0);

        assertTrue(result);
    }

    @Test 
    void returnsTrueForNegativeEvenNumber() {
        boolean result = CourseToolkit.isEven(-8);

        assertTrue(result);
    }

    // // Тесты для isPrime() с составными числами №1
    // @Test void returnsFalseForCompositeNumbers() {

    //     boolean result = CourseToolkit.isPrime(4);
    //     assertFalse(result);

    //     result = CourseToolkit.isPrime(36);
    //     assertFalse(result);
    // }

    // // Тесты для isPrime() с НЕ составными числами №2
    // @Test void returnsTrueForPrime() {

    //     boolean result = CourseToolkit.isPrime(3);
    //     assertTrue(result);

    //     result = CourseToolkit.isPrime(17);
    //     assertTrue(result);

    // }

    // // Тест для isPrime(): число меньше 2 должно вернуть false №3
    // @Test
    // void returnsFalseForNumberLessThanTwo() {
    //     assertFalse(CourseToolkit.isPrime(1));
    // }

    // // Тест для isPrime(): число 2 является простым №4
    // @Test
    // void returnsTrueForTwo() {
    //     assertTrue(CourseToolkit.isPrime(2));
    // }

    // // Тест для isPrime(): квадрат простого числа не является простым №5
    // @Test
    // void returnsFalseForPrimeSquare() {
    //     assertFalse(CourseToolkit.isPrime(49));
    // }

    // // Тест для isPrime(): отрицательное число не является простым №6
    // @Test
    // void returnsFalseForNegativeNumber() {
    //     assertFalse(CourseToolkit.isPrime(-5));
    // }

    // Переписанные тесты для isPrime как ParameterizedTest.
    @ParameterizedTest 
    @CsvSource ({
        "2, true",
        "3, true",
        "4, false",
        "17, true",
        "49, false",
        "1, false",
        "-5, false"
    })
    void checksPrimeNumbers(int number, boolean expected) {
        assertEquals(expected, CourseToolkit.isPrime(number));
    }

    // Тест для isPalindrome(): учитывая регистр и пробелы, слово палиндромно. №1
    @Test
    void returnsTrueForPalindrome() {
        assertTrue(CourseToolkit.isPalindrome("level"));
        assertTrue(CourseToolkit.isPalindrome("АннА"));
        assertTrue(CourseToolkit.isPalindrome(" Ф Ф "));
    }

    // Тест для isPalindrome(): учитывая регистр и пробелы, слово НЕ палиндромно. №2
    @Test 
    void returnsFalseForNonPalindrome() {
        assertFalse(CourseToolkit.isPalindrome("Level"));
        assertFalse(CourseToolkit.isPalindrome(" level"));
        assertFalse(CourseToolkit.isPalindrome("Leve L"));
    }

    // Тест для isPalindrome(): на входе null. №3
    @Test 
    void returnIllegalArgumentExceptionForPalindrome() {
        assertThrows(
        IllegalArgumentException.class,
        () -> CourseToolkit.isPalindrome(null)
        );
    }


    // Тест для average(): корректно считает среднее арифметическое
    @Test 
    void returnsCorrectAverage() {
        assertEquals(2.0, CourseToolkit.average(new int[]{1, 2, 3}));
        assertEquals(1.5, CourseToolkit.average(new int[]{1, 2}));
    }

    // Тест для average(): массив с одним элементом
    @Test
    void returnsAverageForSingleElement() {
        assertEquals(5.0, CourseToolkit.average(new int[]{5}));
    }

    // Тест для average(): null должен выбрасывать IllegalArgumentException
    @Test
    void throwsIllegalArgumentExceptionForNull() {
        assertThrows(
            IllegalArgumentException.class,
            () -> CourseToolkit.average(null)
        );
    }

    // Тест для average(): исходный массив не изменяется
    @Test
    void doesNotModifyArray() {
        int[] values = {1, 2, 3};
        int[] original = {1, 2, 3};

        CourseToolkit.average(values);

        assertArrayEquals(original, values);
    }

}
