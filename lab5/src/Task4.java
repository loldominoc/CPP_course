import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть шлях до каталогу-джерела: ");
        Path sourceDir = Paths.get(scanner.nextLine());

        System.out.print("Введіть шлях до каталогу-призначення: ");
        Path targetDir = Paths.get(scanner.nextLine());

        if (!Files.exists(sourceDir) || !Files.isDirectory(sourceDir)) {
            System.out.println("Каталог-джерело не існує або не є каталогом.");
            return;
        }

        try {
            if (!Files.exists(targetDir)) {
                Files.createDirectories(targetDir);
                System.out.println("Каталог-призначення створено.");
            }

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(sourceDir)) {
                for (Path file : stream) {
                    if (Files.isRegularFile(file)) {
                        Path targetFile = targetDir.resolve(file.getFileName());
                        Files.copy(file, targetFile, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("📄 Скопійовано: " + file.getFileName());
                    }
                }
            }

            System.out.println("Усі файли скопійовано успішно.");
        } catch (IOException e) {
            System.out.println("Помилка копіювання: " + e.getMessage());
        }
    }
}
