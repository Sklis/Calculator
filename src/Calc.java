import java.util.Scanner;

public class Calc {

    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);
        Main result = new Main();
        System.out.println("Введите выражение для вычисления, где числа в диаппазоне от 1 до 10: ");
        String expr = input.nextLine(), finish = "";

        expr = expr.toUpperCase(); // Переводим все в верхний регистр

        try {
            finish = result.calc(expr);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(new Error("В выражении отсутствует арифметический знак!"));
            System.exit(0);
        }

        System.out.println(finish);
    }
}
class Main {
    public static String calc(String input) {

        int num1 = 0, num2 = 0, result = 0;
        String[] arr = new String[5];
        String[] numbers = {"N", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII",
                "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV",
                "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
                "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX",
                "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII",
                "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV",
                "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI",
                "XCVII", "XCVIII", "XCIX", "C"};

        String finish = "";

        arr = input.trim().split("[+\\-/\\*]");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim();
        }

        // Проверка на правильность написания выражения

        // Проверка что введене два числа
        if (arr.length > 2) {
            System.out.println(new Error("Не допустимое выражение!"));
            System.exit(0);
        }
        // Проверка, что цифры написаны в одинаковом формате
        try {
            num1 = Integer.parseInt(arr[0]);
            num2 = Integer.parseInt(arr[1]);
        } catch (NumberFormatException e) {
            if (arr[0].matches("[IVX]") && arr[1].matches("[0-9]")) {
                System.out.println(new Error("Не допустимое выражение"));
                System.exit(0);
            } else if (arr[0].matches("[0-9]") && arr[1].matches("[IVX]")) {
                System.out.println(new Error("Не допустимое выражение"));
                System.exit(0);
            } else {
                for (int i = 0; i < numbers.length; i++) {
                    if (arr[0].equals(numbers[i])) {
                        num1 = i;
                    }
                }

                for (int i = 0; i < numbers.length; i++) {
                    if (arr[1].equals(numbers[i])) {
                        num2 = i;
                    }
                }

                if ((num1 < num2) && input.contains("-")) {
                    System.out.println(new Error("В римской системе нет отрицательных чисел"));
                    System.exit(0);
                }
            }

        }

        if ((num1 < 1 || num1 > 10) || (num2 < 1 || num2 > 10)) {
            System.out.println(new Error("Вы ввели числа не в том диапазоне."));
            System.exit(0);
        }

        // Проверка арифметического знака и выполнение действия
        if (input.contains("+")) {
            result = num1 + num2;
        } else if (input.contains("-")) {
            result = num1 - num2;
        } else if (input.contains("*")) {
            result = num1 * num2;
        } else if (input.contains("/")) {
            result = num1 / num2;
        }


        // Выводим результат
        if (input.contains("I") || input.contains("V") || input.contains("X")) {
            finish = numbers[result];
        } else {
            finish = "" + result;
        }

        return finish;
    }
}
