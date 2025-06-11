import java.util.List;

public class Newspaper implements LibraryItem {
    private final String title;
    private final String publishDate;
    private final List<String> headlines;

    public Newspaper(String title, String publishDate, List<String> headlines) {
        this.title = title;
        this.publishDate = publishDate;
        this.headlines = headlines;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void displayInfo() {
        System.out.println("Газета: \"" + title + "\", дата: " + publishDate);
        System.out.println("  Заголовки:");
        for (String headline : headlines) {
            System.out.println("   - " + headline);
        }
    }

    @Override
    public boolean matchesAuthor(String author) {
        return false;
    }
}
