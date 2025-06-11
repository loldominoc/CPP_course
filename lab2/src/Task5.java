public class Task5 {
    public static String removeRuEmails(String input) {
        return input.replaceAll("\\b[\\w.%+-]+@[\\w.-]+\\.ru\\b", "");
    }

    public static void main(String[] args) {
        String emails = "Зв’яжіться з нами: ivan@gmail.com, spam@kreml.ru, test@ukr.net, agent@fsb.ru";
        System.out.println("Після видалення: " + removeRuEmails(emails));
    }
}