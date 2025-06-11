import java.util.regex.*;

public class Task1 {
    public static void main(String[] args) {
        String[] text = {
                "Це перше речення. Воно містить слова і розділові знаки!",
                "Інше речення тут. Можливо, довше, або ні.",
                "Це найдовше і найдетальніше побудоване речення з усіх, мабуть?"
        };

        for (String line : text) {
            int wordCount = line.trim().split("\\s+").length;
            int sentenceCount = line.split("[.!?]").length;
            System.out.println("Рядок: " + line);
            System.out.println("Слів: " + wordCount + ", Речень: " + sentenceCount);
        }

        String longest = "";
        for (String line : text) {
            if (line.length() > longest.length()) {
                longest = line;
            }
        }

        System.out.println("Найдовший рядок дубльовано: " + longest + " " + longest);

        String[] banned = {"речення", "довше"};
        for (String word : banned) {
            longest = longest.replaceAll("(?i)" + word, "*".repeat(word.length()));
        }
        System.out.println("Цензуровано: " + longest);
    }
}