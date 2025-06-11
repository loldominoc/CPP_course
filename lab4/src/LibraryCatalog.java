import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LibraryCatalog {
    private final List<LibraryItem> items = new ArrayList<>();

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void addRandomItem() {
        Random rnd = new Random();
        if (rnd.nextBoolean()) {
            addItem(new Book("Випадковий Автор", "Випадкова Книга", "Фантастика", rnd.nextInt(100) + 100));
        } else {
            List<String> headlines = List.of("Новини дня", "Політика", "Спорт");
            addItem(new Newspaper("Щоденник", "10.06.2025", headlines));
        }
    }

    public void removeByTitle(String title) {
        items.removeIf(item -> item.getTitle().equalsIgnoreCase(title));
    }

    public void searchByTitle(String title) {
        for (LibraryItem item : items) {
            if (item.getTitle().toLowerCase().contains(title.toLowerCase())) {
                item.displayInfo();
            }
        }
    }

    public void searchByAuthor(String author) {
        for (LibraryItem item : items) {
            if (item.matchesAuthor(author)) {
                item.displayInfo();
            }
        }
    }

    public void printAll() {
        for (LibraryItem item : items) {
            item.displayInfo();
            System.out.println();
        }
    }

    public void initTestData() {
        addItem(new Book("Іван Франко", "Захар Беркут", "Історичний роман", 250));
        addItem(new Book("Леся Українка", "Лісова пісня", "Драма-феєрія", 120));

        List<String> headlines = List.of("Світові новини", "Курс валют", "Погода");
        addItem(new Newspaper("Вечірній Київ", "09.06.2025", headlines));

        List<Book> almanacBooks = List.of(
                new Book("Олесь Гончар", "Прапороносці", "Воєнна проза", 300),
                new Book("Василь Стус", "Збірка поезій", "Поезія", 200)
        );
        addItem(new Almanac("Сучасна українська література", almanacBooks));
    }
}
