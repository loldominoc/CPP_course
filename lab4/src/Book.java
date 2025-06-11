public class Book implements LibraryItem {
    private final String author;
    private final String title;
    private final String genre;
    private final int pages;

    public Book(String author, String title, String genre, int pages) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void displayInfo() {
        System.out.println("Книга: \"" + title + "\", автор: " + author +
                ", жанр: " + genre + ", сторінок: " + pages);
    }

    @Override
    public boolean matchesAuthor(String author) {
        return this.author.toLowerCase().contains(author.toLowerCase());
    }
}
