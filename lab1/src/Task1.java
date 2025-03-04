import java.util.Scanner;

public class Task1 {
    public static void run() {
        Scanner scn = new Scanner(System.in);

        System.out.print("Введіть перше число: ");
        int x = scn.nextInt();

        System.out.print("Введіть друге число: ");
        int y = scn.nextInt();

        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }

        System.out.println("Непарні числа в діапазоні [" + x + ", " + y + "]:");
        for(int i = x; i <= y; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }

        scn.close();
    }
}
