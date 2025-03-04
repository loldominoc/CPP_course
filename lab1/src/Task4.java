import java.util.Scanner;

public class Task4 {
    public static void run() {
        int minNumber = findMinPositiveNumber();

        if (minNumber != -1) {
            System.out.println("Мінімальне додатне число: " + minNumber);
        } else {
            System.out.println("Не введено жодного числа, яке більше 9.");
        }
    }

    public static int findMinPositiveNumber() {
        Scanner scn = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        boolean validInput = false;

        while (true) {
            System.out.print("Введіть додатне число (або число від 0 до 9 для завершення): ");
            int number = scn.nextInt();

            if (number <= 9) {
                break;
            }

            if (number > 9) {
                validInput = true;
                if (number < min) {
                    min = number;
                }
            }
        }

        if (validInput) {
            return min;
        } else {
            return -1;
        }
    }
}
