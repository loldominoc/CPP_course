public class Task3 {
    public static boolean isSecurePassword(String password) {
        return password.length() >= 8 &&
                password.matches(".*[a-z].*") &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*\\d.*") &&
                password.matches(".*[!*_.].*");
    }

    public static void main(String[] args) {
        String password = "Безпечний_123";
        System.out.println("Пароль надійний? " + isSecurePassword(password));
    }
}
