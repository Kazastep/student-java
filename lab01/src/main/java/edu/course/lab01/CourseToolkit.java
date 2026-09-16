package edu.course.lab01;

/**
 * Небольшие методы для первой лабораторной работы.
 */
public final class CourseToolkit {

    private CourseToolkit() {
        // Утилитарный класс не должен иметь экземпляров.
    }

    /**
     * Возвращает true, если число четное.
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // public static boolean isEven(int number) {

    // }

    public static boolean isPrime(int number) {
        // Метод проверяет является ли число составным. Если число составное возвращает False если нет то True.

        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome(String text) {
        // Метод проверяет является ли строка палиндромной. 

        if (text == null) {

            throw new IllegalArgumentException();
        }
        
        int textLength = text.length();

        for (int i = 0; i < textLength / 2; i++ ) {

            if (text.charAt(i) != text.charAt(textLength - i - 1)) {
                return false;
            }
        }
        return true;

    }

    public static double average(int[] values) {
        // Метод возвращает дробный результат и не изменяет массив.

        if (values == null || values.length == 0) {
            throw new IllegalArgumentException();
        }

        double sum = 0;

        for (double value: values) {
            sum += value;
        }

        double answer = sum / values.length;

        return answer;

    }

    public static int min(int[] values) {
        // Метод получает массив и возвращает его минимальное значение

        if (values == null || values.length == 0) {
            throw new IllegalArgumentException();
        }

        int minValue = values[0];
        for (int value: values) {
            if (value < minValue) {
                minValue = value;
            }
        }
        return minValue;

    }

    public static int max(int[] values) {
        // Метод получает массив и возвращает его максимальное значение

        if (values == null || values.length == 0) {
            throw new IllegalArgumentException();
        }

        int maxValue = values[0];
        for (int value: values) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;

    }

    public static void main(String[] args) {
        // CLI для prime, palindrome, average.

        if (args.length == 0) {
            System.out.println("Command is required");
            return;
        }

        String name = args[0];

        if (name.equals("prime")) {

            int number = Integer.parseInt(args[1]);
            System.out.println(CourseToolkit.isPrime(number));
        }

        else if (name.equals("palindrome")) {

            String word = args[1];
            System.out.println(CourseToolkit.isPalindrome(word));            
        }

        else if (name.equals("average")) {

            int[] values = new int[args.length - 1];
            for (int i = 1; i < args.length; i++) {
                values[i - 1] = Integer.parseInt(args[i]);
            }
            double result = CourseToolkit.average(values);
            System.out.println(result);

        }
        
    }
}
