import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть шлях до каталогу з текстовими файлами: ");
        Path folder = Paths.get(scanner.nextLine());

        List<String> bannedWords;
        try {
            bannedWords = Files.readAllLines(Paths.get("banned_words.txt"), StandardCharsets.UTF_8)
                    .stream().map(String::trim).filter(s -> !s.isEmpty()).toList();

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(folder, "*.txt")) {
                boolean foundAny = false;

                for (Path file : stream) {
                    String content = Files.readString(file, StandardCharsets.UTF_8);
                    Map<String, Integer> found = new LinkedHashMap<>();

                    for (String word : bannedWords) {
                        Matcher m = Pattern.compile("(?i)" + Pattern.quote(word)).matcher(content);
                        int count = 0;
                        while (m.find()) count++;
                        if (count > 0) found.put(word, count);
                    }

                    if (!found.isEmpty()) {
                        foundAny = true;
                        System.out.println("\nФайл: " + file.getFileName());
                        found.forEach((w, c) -> System.out.println(w + " — " + c + " раз(ів)"));
                        System.out.print("Замінити ці слова на * у цьому файлі? (так/ні): ");
                        if (scanner.nextLine().trim().equalsIgnoreCase("так")) {
                            for (String word : bannedWords) {
                                String stars = "*".repeat(word.length());
                                content = content.replaceAll("(?i)" + Pattern.quote(word), stars);
                            }
                            Files.writeString(file, content, StandardCharsets.UTF_8);
                            System.out.println("Оновлено: " + file.getFileName());
                        }
                    }
                }

                if (!foundAny) System.out.println("У жодному файлі не знайдено заборонених слів.");
            }

        } catch (IOException e) {
            System.out.println("Помилка при обробці файлів: " + e.getMessage());
        }
    }
}