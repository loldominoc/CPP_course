import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Equipment[] equipmentList = {
                new Equipment("Мікроскоп", 2, "Іваненко", "01.06.2025"),
                new Equipment("Центрифуга", 1),
                new Equipment("Колба 100 мл", 10, "Сидоренко", "05.06.2025"),
                new Equipment("Термометр", 5),
                new Equipment("Піпетка", 20, "Коваль", "03.06.2025"),
                new Equipment("Фільтрувальний папір", 100),
                new Equipment("Штатив", 4)
        };

        LabInventory lab = new LabInventory(equipmentList);

        System.out.println("=== УСЕ ОБЛАДНАННЯ ===");
        lab.printAll();

        System.out.println("\n=== НАЯВНЕ ОБЛАДНАННЯ ===");
        lab.printByStatus(true);

        System.out.println("\n=== ВИДАНЕ ОБЛАДНАННЯ ===");
        lab.printByStatus(false);

        Scanner sc = new Scanner(System.in);
        System.out.print("\n🔍 Введіть назву обладнання для пошуку: ");
        String query = sc.nextLine();
        sc.close();

        System.out.println("\n=== РЕЗУЛЬТАТ ПОШУКУ ===");
        lab.searchByName(query);

        System.out.println("\n================================================\n");

        Animal[] zoo = {
                new Tiger("Шерхан"),
                new Rabbit("Квік"),
                new Wolf("Сірко"),
                new Kangaroo("Джой"),
                new Rabbit("Сніжок"),
                new Tiger("Амур")
        };

        System.out.println("=== Тварини в зоопарку ===");
        int predatorCount = 0;
        double totalFood = 0;

        for (Animal a : zoo) {
            a.printInfo();
            System.out.println("Звук: " + a.makeSound());
            totalFood += a.getDailyFoodKg();
            if (a.isPredator()) {
                predatorCount++;
            }
            System.out.println();
        }

        System.out.println("Загальна кількість хижаків: " + predatorCount);
        System.out.println("Сумарна потреба в кормі: " + totalFood + " кг/день");

        System.out.println("\n================================================\n");

        MusicalInstrument[] instruments = {
                new Violin(),
                new Trombone(),
                new Ukulele(),
                new Cello()
        };

        for (MusicalInstrument instrument : instruments) {
            System.out.println("=====");
            instrument.show();
            instrument.sound();
            instrument.desc();
            instrument.history();
        }
    }
}