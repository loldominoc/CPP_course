import java.io.Serializable;

public class Equipment implements Serializable, Comparable<Equipment> {
    private final String name;
    private final int quantity;
    private String issuedTo;
    private boolean isReturned;

    public Equipment(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.issuedTo = "Невидано";
        this.isReturned = true;
    }

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public String getIssuedTo() { return issuedTo; }
    public boolean isReturned() { return isReturned; }

    public void issue(String person) {
        if (isReturned) {
            this.issuedTo = person;
            this.isReturned = false;
        }
    }

    public void returnEquipment() {
        if (!isReturned) {
            this.isReturned = true;
            this.issuedTo = "Невидано";
        }
    }

    @Override
    public int compareTo(Equipment other) {
        int nameCmp = this.name.compareToIgnoreCase(other.name);
        if (nameCmp != 0) return nameCmp;
        return Integer.compare(this.quantity, other.quantity);
    }

    @Override
    public String toString() {
        return name + " (" + quantity + " шт.) - " +
                (isReturned ? "на складі" : "видано " + issuedTo);
    }
}
