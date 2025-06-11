import java.io.*;
import java.util.Arrays;

public class InventoryManager {
    public static void saveToFile(Equipment[] items, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(items);
            System.out.println("Дані збережено у файл.");
        } catch (IOException e) {
            System.err.println("Помилка при збереженні: " + e.getMessage());
        }
    }

    public static Equipment[] loadFromFile(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Equipment[]) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка при зчитуванні: " + e.getMessage());
            return new Equipment[0];
        }
    }

    public static void sortAndPrint(Equipment[] items) {
        Arrays.sort(items);
        System.out.println("Відсортований список:");
        for (Equipment item : items) {
            System.out.println(item);
        }
    }
}