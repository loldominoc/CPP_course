import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Task3 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Corporation corporation = new Corporation();
    private static String employeeFile = "";

    public static void main(String[] args) {
        System.out.print("Введіть шлях до файлу зі співробітниками (наприклад, employees.csv): ");
        employeeFile = scanner.nextLine();

        try {
            corporation.loadFromFile(employeeFile);
            System.out.println("Дані успішно завантажено.");
        } catch (IOException e) {
            System.out.println("Файл не знайдено або порожній. Починаємо з порожнього списку.");
        }

        boolean running = true;
        while (running) {
            showMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> addEmployee();
                case "2" -> editEmployee();
                case "3" -> deleteEmployee();
                case "4" -> searchByLastName();
                case "5" -> filterMenu();
                case "6" -> saveReport();
                case "7" -> manualSave();
                case "8" -> {
                    if (corporation.hasChanges()) {
                        manualSave();
                    }
                    running = false;
                    System.out.println("Завершення роботи.");
                }
                default -> System.out.println("Невідома команда.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("""
                
                ===== МЕНЮ =====
                1. Додати співробітника
                2. Редагувати співробітника
                3. Видалити співробітника
                4. Пошук за прізвищем
                5. Вивід усіх / фільтрація
                6. Зберегти вибраний список у звіт
                7. Зберегти всі зміни у файл
                8. Вийти з програми
                =================
                Виберіть дію: """);
    }

    private static void addEmployee() {
        System.out.print("Ім’я: ");
        String first = scanner.nextLine();
        System.out.print("Прізвище: ");
        String last = scanner.nextLine();
        System.out.print("Вік: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Посада: ");
        String position = scanner.nextLine();

        corporation.addEmployee(first, last, age, position);
        System.out.println("Додано.");
    }

    private static void editEmployee() {
        System.out.print("Введіть ID співробітника: ");
        int id = Integer.parseInt(scanner.nextLine());
        Employee emp = corporation.findById(id);
        if (emp == null) {
            System.out.println("Не знайдено.");
            return;
        }

        System.out.print("Нове ім’я [" + emp.getFirstName() + "]: ");
        String first = scanner.nextLine();
        if (!first.isBlank()) emp.setFirstName(first);

        System.out.print("Нове прізвище [" + emp.getLastName() + "]: ");
        String last = scanner.nextLine();
        if (!last.isBlank()) emp.setLastName(last);

        System.out.print("Новий вік [" + emp.getAge() + "]: ");
        String ageStr = scanner.nextLine();
        if (!ageStr.isBlank()) emp.setAge(Integer.parseInt(ageStr));

        System.out.print("Нова посада [" + emp.getPosition() + "]: ");
        String pos = scanner.nextLine();
        if (!pos.isBlank()) emp.setPosition(pos);

        System.out.println("Змінено.");
    }

    private static void deleteEmployee() {
        System.out.print("Введіть ID співробітника: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean removed = corporation.removeEmployeeById(id);
        System.out.println(removed ? "Видалено." : "Не знайдено.");
    }

    private static void searchByLastName() {
        System.out.print("Введіть прізвище для пошуку: ");
        String last = scanner.nextLine();
        List<Employee> result = corporation.searchByLastName(last);
        if (result.isEmpty()) {
            System.out.println("Нічого не знайдено.");
        } else {
            result.forEach(System.out::println);
        }
    }

    private static void filterMenu() {
        System.out.println("""
                1. Всі співробітники
                2. Фільтр за віком
                3. Фільтр за першою літерою прізвища
                Вибір: """);
        String sub = scanner.nextLine();

        List<Employee> list = switch (sub) {
            case "1" -> corporation.getAll();
            case "2" -> {
                System.out.print("Вік: ");
                int age = Integer.parseInt(scanner.nextLine());
                yield corporation.filterByAge(age);
            }
            case "3" -> {
                System.out.print("Перша літера прізвища: ");
                char ch = scanner.nextLine().charAt(0);
                yield corporation.filterByLastNameStart(ch);
            }
            default -> List.of();
        };

        if (list.isEmpty()) {
            System.out.println("Нічого не знайдено.");
        } else {
            list.forEach(System.out::println);
        }
    }

    private static void saveReport() {
        System.out.print("Введіть шлях до файлу звіту (наприклад, report.txt): ");
        String path = scanner.nextLine();
        System.out.print("Зберегти повний список? (так/ні): ");
        String all = scanner.nextLine();
        List<Employee> toSave = all.equalsIgnoreCase("так") ? corporation.getAll() : manualSelection();
        try {
            corporation.saveReport(toSave, path);
            System.out.println("Звіт збережено.");
        } catch (IOException e) {
            System.out.println("Помилка збереження: " + e.getMessage());
        }
    }

    private static List<Employee> manualSelection() {
        System.out.println("✳Цей режим ще не реалізований, буде збережено весь список.");
        return corporation.getAll();
    }

    private static void manualSave() {
        try {
            corporation.saveToFile(employeeFile);
            System.out.println("Дані збережено.");
        } catch (IOException e) {
            System.out.println("Не вдалося зберегти: " + e.getMessage());
        }
    }
}
