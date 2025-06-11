import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Equipment {
    private final String name;
    private final int quantity;
    private String issuedTo;
    private boolean isReturned;
    private LocalDate issueDate;

    public Equipment(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.issuedTo = "Невидано";
        this.isReturned = true;
        this.issueDate = null;
    }

    public Equipment(String name, int quantity, String issuedTo, String issueDateStr) {
        this.name = name;
        this.quantity = quantity;
        this.issuedTo = issuedTo;
        this.isReturned = false;
        this.issueDate = LocalDate.parse(issueDateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public String getIssuedTo() { return issuedTo; }
    public boolean isReturned() { return isReturned; }
    public String getIssueDate() {
        return (issueDate != null)
                ? issueDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                : "";
    }

    // Видача обладнання
    public void issue(String person, String dateStr) {
        if (isReturned) {
            this.issuedTo = person;
            this.isReturned = false;
            this.issueDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }

    // Повернення обладнання
    public void returnEquipment() {
        if (!isReturned) {
            this.isReturned = true;
            this.issuedTo = "Невидано";
            this.issueDate = null;
        }
    }

    @Override
    public String toString() {
        return name + " (" + quantity + " шт.) — " +
                (isReturned ? "у наявності" : "видано " + issuedTo + " [" + getIssueDate() + "]");
    }

    public String toString(boolean shortView) {
        return shortView ? name + " — " + (isReturned ? "в наявності" : "видано") : toString();
    }
}