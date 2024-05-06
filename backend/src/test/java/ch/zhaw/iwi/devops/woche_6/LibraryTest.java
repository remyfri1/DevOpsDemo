package ch.zhaw.iwi.devops.woche_6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;
    
    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("1984", "George Orwell");
        book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        library.addBook(book1);
        library.addBook(book2);
    }

    @Test
    public void testAddBookIncreasesCount() {
        assertEquals(2, library.countBooks());
        library.addBook(new Book("Brave New World", "Aldous Huxley"));
        assertEquals(3, library.countBooks());
    }

}
