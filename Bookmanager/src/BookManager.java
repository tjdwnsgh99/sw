import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> books = new ArrayList<>();

    public static class Book {
        private int id;
        private String title;
        private String author;
        private int year;

        public Book(int id, String title, String author, int year) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.year = year;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public int getYear() {
            return year;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", year=" + year +
                    '}';
        }
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book searchBookById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    public boolean deleteBookById(int id) {
        return books.removeIf(book -> book.getId() == id);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}

