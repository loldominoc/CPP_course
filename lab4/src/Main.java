public class Main {
    public static void main(String[] args) {
        Equipment[] items = {
                new Equipment("Мікроскоп", 2),
                new Equipment("Колба", 10),
                new Equipment("Піпетка", 20),
                new Equipment("Термометр", 5),
                new Equipment("Штатив", 4)
        };

        items[1].issue("Іваненко");

        InventoryManager.saveToFile(items, "equipment.dat");

        Equipment[] loaded = InventoryManager.loadFromFile("equipment.dat");

        InventoryManager.sortAndPrint(loaded);

        System.out.println("\n================================================\n");

        House house = new House();

        Worker w1 = new Worker("Олег");
        Worker w2 = new Worker("Марія");
        TeamLeader leader = new TeamLeader("Бригадир Василь");

        Team team = new Team(w1, w2, leader);
        team.buildHouse(house);

        System.out.println("\nБудівництво завершено.");

        System.out.println("\n================================================\n");

        LibraryCatalog catalog = new LibraryCatalog();

        System.out.println("Ініціалізація даних...");
        catalog.initTestData();

        System.out.println("\nУвесь каталог:");
        catalog.printAll();

        System.out.println("Пошук за автором 'Франко':");
        catalog.searchByAuthor("Франко");

        System.out.println("Пошук за назвою 'Київ':");
        catalog.searchByTitle("Київ");

        System.out.println("\nДодавання випадкового об'єкта:");
        catalog.addRandomItem();
        catalog.printAll();

        System.out.println("Видалення об'єкта за назвою 'Захар Беркут':");
        catalog.removeByTitle("Захар Беркут");

        System.out.println("Каталог після видалення:");
        catalog.printAll();
    }
}