import java.util.regex.*;

public class Task4 {
    public static void main(String[] args) {
        String input = "Situation: Motivation, Action! Obligation. Cooperation, Reduction!";

        Pattern pattern = Pattern.compile("\\b[A-Z][a-zA-Z]{1,8}tion[,.!:;]");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println("Збіг: " + matcher.group());
        }
    }
}