import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class Corporation {
    private List<Employee> employees = new ArrayList<>();
    private boolean changed = false;
    private int nextId = 1;

    public void addEmployee(String firstName, String lastName, int age, String position) {
        employees.add(new Employee(nextId++, firstName, lastName, age, position));
        changed = true;
    }

    public boolean removeEmployeeById(int id) {
        boolean removed = employees.removeIf(e -> e.getId() == id);
        if (removed) changed = true;
        return removed;
    }

    public Employee findById(int id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public List<Employee> searchByLastName(String lastName) {
        return employees.stream()
                .filter(e -> e.getLastName().equalsIgnoreCase(lastName))
                .toList();
    }

    public List<Employee> filterByAge(int age) {
        return employees.stream()
                .filter(e -> e.getAge() == age)
                .toList();
    }

    public List<Employee> filterByLastNameStart(char letter) {
        return employees.stream()
                .filter(e -> e.getLastName().toLowerCase().startsWith(String.valueOf(letter).toLowerCase()))
                .toList();
    }

    public List<Employee> getAll() {
        return employees;
    }

    public boolean hasChanges() {
        return changed;
    }

    public void markSaved() {
        changed = false;
    }

    public void loadFromFile(String filePath) throws IOException {
        employees.clear();
        List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
        for (String line : lines) {
            Employee e = Employee.fromCSV(line);
            employees.add(e);
            if (e.getId() >= nextId) {
                nextId = e.getId() + 1;
            }
        }
        changed = false;
    }

    public void saveToFile(String filePath) throws IOException {
        List<String> lines = employees.stream()
                .map(Employee::toCSV)
                .toList();
        Files.write(Paths.get(filePath), lines, StandardCharsets.UTF_8);
        changed = false;
    }

    public void saveReport(List<Employee> list, String reportFilePath) throws IOException {
        List<String> lines = list.stream()
                .map(Employee::toString)
                .toList();
        Files.write(Paths.get(reportFilePath), lines, StandardCharsets.UTF_8);
    }
}
