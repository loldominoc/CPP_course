public interface LibraryItem {
    String getTitle();
    void displayInfo();
    boolean matchesAuthor(String author);
}
