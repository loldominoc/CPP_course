import java.util.List;

public class Almanac implements LibraryItem {
    private final String title;
    private final List<Book> books;

    public Almanac(String title, List<Book> books) {
        this.title = title;
        this.books = books;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void displayInfo() {
        System.out.println("Альманах: \"" + title + "\", містить:");
        for (Book book : books) {
            System.out.print("   - ");
            book.displayInfo();
        }
    }

    @Override
    public boolean matchesAuthor(String author) {
        return books.stream().anyMatch(book -> book.matchesAuthor(author));
    }
}
