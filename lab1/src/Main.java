import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Виберіть завдання:");
        System.out.println("Завдання 1");
        System.out.println("Завдання 2");
        System.out.println("Завдання 3");
        System.out.println("Завдання 4");
        System.out.println("Завдання 5");
        System.out.println("Завдання 6");
        System.out.print("Ваш вибір: ");

        int choice = scn.nextInt();

        if (choice == 1) {
            System.out.println("Вибрано завдання 1");
            Task1.run();
        } else if (choice == 2) {
            System.out.println("Вибрано завдання 2");
            Task2.run();
        } else if (choice == 3) {
            System.out.println("Вибрано завдання 3");
            Task3.run();
        } else if (choice == 4) {
            System.out.println("Вибрано завдання 4");
            Task4.run();
        } else if (choice == 5) {
            System.out.println("Вибрано завдання 5");
            Task5.run();
        } else if (choice == 6) {
            System.out.println("Вибрано завдання 6");
            Task6.run();
        } else {
            System.out.println("Невірний вибір. Будь ласка, спробуйте ще раз.");
        }

        scn.close();
    }
}
