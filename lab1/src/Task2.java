import java.util.Scanner;

public class Task2 {
    public static void run() {
        Scanner scn = new Scanner(System.in);

        int distanceAB = 600;
        int distanceBC = 700;
        int weight = 400;
        int fuelCapacity = 1000;

        scn.close();

        int fuelConsumptionPerKm = fuelConsumption(weight);
        if (fuelConsumptionPerKm == -1) {
            System.out.println("Літак не піднімає вантаж більше 2000 кг");
            return;
        }

        int totalFuelRequiredAB = fuelConsumptionPerKm * distanceAB;
        int totalFuelRequiredBC = fuelConsumptionPerKm * distanceBC;

        if (totalFuelRequiredAB > fuelCapacity) {
            System.out.println("Неможливо подолати відстань з пункту А до пункту В");
            return;
        }

        int fuelLeftAfterAB = fuelCapacity - totalFuelRequiredAB;
        int fuelRequiredForBC = totalFuelRequiredBC;

        if (fuelLeftAfterAB < fuelRequiredForBC) {
            int fuelNeededAtB = fuelRequiredForBC - fuelLeftAfterAB;
            System.out.println("Необхідна кількість палива для дозаправки в пункті В: " + fuelNeededAtB);
        } else {
            System.out.println("Дозаправка не потрібна");
        }
    }

    public static int fuelConsumption(int weight) {
        if (weight <= 500) {
            return 1;
        } else if (weight <= 1000) {
            return 4;
        } else if (weight <= 1500) {
            return 7;
        } else if (weight <= 2000) {
            return 9;
        } else {
            return -1;
        }
    }
}
