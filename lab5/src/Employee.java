public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String position;

    public Employee(int id, String firstName, String lastName, int age, String position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.position = position;
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getPosition() { return position; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAge(int age) { this.age = age; }
    public void setPosition(String position) { this.position = position; }

    @Override
    public String toString() {
        return id + ": " + firstName + " " + lastName + ", age " + age + ", " + position;
    }

    public String toCSV() {
        return id + "," + firstName + "," + lastName + "," + age + "," + position;
    }

    public static Employee fromCSV(String line) {
        String[] parts = line.split(",");
        return new Employee(
                Integer.parseInt(parts[0]),
                parts[1],
                parts[2],
                Integer.parseInt(parts[3]),
                parts[4]
        );
    }
}
