import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть шлях до першого файлу:");
        String filePath1 = scanner.nextLine();

        System.out.println("Введіть шлях до другого файлу:");
        String filePath2 = scanner.nextLine();

        try {
            List<String> lines1 = Files.readAllLines(Paths.get(filePath1));
            List<String> lines2 = Files.readAllLines(Paths.get(filePath2));

            int maxLines = Math.max(lines1.size(), lines2.size());
            boolean hasDifferences = false;

            for (int i = 0; i < maxLines; i++) {
                String line1 = (i < lines1.size()) ? lines1.get(i) : "";
                String line2 = (i < lines2.size()) ? lines2.get(i) : "";

                if (!line1.equals(line2)) {
                    hasDifferences = true;
                    System.out.println("Рядок №" + (i + 1) + " не збігається:");
                    System.out.println("Файл 1: " + line1);
                    System.out.println("Файл 2: " + line2);
                    System.out.println();
                }
            }

            if (!hasDifferences) {
                System.out.println("Файли повністю збігаються.");
            }

        } catch (IOException e) {
            System.out.println("Сталася помилка при зчитуванні файлів: " + e.getMessage());
        }
    }
}