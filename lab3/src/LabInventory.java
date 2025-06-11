public class LabInventory {
    private Equipment[] items;

    public LabInventory(Equipment[] items) {
        this.items = items;
    }

    public void printAll() {
        for (Equipment e : items) {
            System.out.println(e);
        }
    }

    public void printByStatus(boolean isReturned) {
        for (Equipment e : items) {
            if (e.isReturned() == isReturned) {
                System.out.println(e.toString(true));
            }
        }
    }

    public void searchByName(String name) {
        boolean found = false;
        for (Equipment e : items) {
            if (e.getName().equalsIgnoreCase(name)) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Обладнання з назвою \"" + name + "\" не знайдено.");
        }
    }
}