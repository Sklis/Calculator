import java.util.Scanner;

public class Calc {

    public static void main(String[] args) {
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

