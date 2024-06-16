import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookManagerTest {
    private BookManager bookManager;

    @BeforeEach
    public void setUp() {
        bookManager = new BookManager();
        bookManager.addBook(new BookManager.Book(1, "Java Programming", "John Doe", 2020));
        bookManager.addBook(new BookManager.Book(2, "Effective Java", "Joshua Bloch", 2018));
        bookManager.addBook(new BookManager.Book(3, "Clean Code", "Robert C. Martin", 2008));
    }

    @Test
    public void testAddBook() {
        BookManager.Book newBook = new BookManager.Book(4, "Design Patterns", "Erich Gamma", 1994);
        bookManager.addBook(newBook);
        System.out.println("Book added: " + newBook);
        assertEquals(newBook, bookManager.searchBookById(4));
    }

    @Test
    public void testSearchBookById() {
        BookManager.Book book = bookManager.searchBookById(2);
        assertNotNull(book);
        assertEquals("Effective Java", book.getTitle());
    }

    @Test
    public void testDeleteBookById() {
        boolean result = bookManager.deleteBookById(3);
        if (result) {
            System.out.println("Book deleted: Book ID 3");
        }
        assertTrue(result);
        assertNull(bookManager.searchBookById(3));
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Current book list:");
        for (BookManager.Book book : bookManager.getAllBooks()) {
            System.out.println(book);
        }
    }
}

