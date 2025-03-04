import java.util.Scanner;

public class Task3 {
    public static void run() {
        Scanner scn = new Scanner(System.in);

        String[] menuItems = {"Кава - 30 грн", "Чай - 20 грн", "Кекс - 25 грн", "Торт - 50 грн", "Сендвіч - 40 грн"};
        int[] menuPrices = {30, 20, 25, 50, 40};

        double totalOrderPrice = 0;

        System.out.print("Введіть кількість гостей у компанії: ");
        int numberOfPeople = scn.nextInt();

        for (int i = 1; i <= numberOfPeople; i++) {
            double personTotalPrice = 0;
            System.out.println("\nМеню для гостя " + i + ":");
            for (int j = 0; j < menuItems.length; j++) {
                System.out.println((j + 1) + ". " + menuItems[j]);
            }

            while (true) {
                System.out.print("\nВиберіть позицію (введіть номер страви або 0 для завершення): ");
                int choice = scn.nextInt();

                if (choice == 0) {
                    break;
                } else if (choice > 0 && choice <= menuItems.length) {
                    System.out.print("Скільки одиниць цього товару ви хочете замовити? ");
                    int quantity = scn.nextInt();
                    personTotalPrice += menuPrices[choice - 1] * quantity;
                } else {
                    System.out.println("Невірний вибір, спробуйте ще раз.");
                }
            }

            System.out.println("Загальна сума для людини " + i + ": " + personTotalPrice + " грн");
            totalOrderPrice += personTotalPrice;
        }

        System.out.println("\nЗагальна сума замовлення для всієї компанії: " + totalOrderPrice + " грн");

        scn.close();
    }
}
