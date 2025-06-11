public class Task2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Робота з StringBuilder в Java");

        String sub1 = sb.substring(8, 22); // "StringBuilder"
        System.out.println("Підрядок: " + sub1);

        sb.append(" — це зручно.");
        sb.insert(6, " >>> ");
        System.out.println("Після вставки та додавання: " + sb);

        sb.delete(6, 11); // видаляємо " >>> "
        sb.insert(6, "[ВСТАВЛЕНО]");
        System.out.println("Змінено: " + sb);
    }
}
