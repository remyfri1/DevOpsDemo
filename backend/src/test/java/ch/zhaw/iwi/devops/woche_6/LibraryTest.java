package ch.zhaw.iwi.devops.woche_6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    //test 1
    public void testAddBookIncreasesCount() {
        assertEquals(2, library.countBooks());
        library.addBook(new Book("Brave New World", "Aldous Huxley"));
        assertEquals(3, library.countBooks());
    }

    @Test
    //test 3
    public void testSearchByTitle() {
        List<Book> results = library.searchByTitle("1984");
        assertFalse(results.isEmpty());
        assertEquals(0, results.size());
        assertEquals(book1, results.get(0));
    }


    @Test
    //test 2
    public void testSearchByAuthor() {
        List<Book> results = library.searchByAuthor("Harper Lee");
        assertFalse(results.isEmpty());
        assertEquals(0, results.size());
        assertEquals(book2, results.get(0));
    }


    @Test
    //test 4
    public void testBorrowBook() {
        library.borrowBook(book1);
        assertEquals(2, library.countBooks());
        assertEquals(1, library.countBorrowedBooks());
    }



    @Test
    //test 5
    public void testReturnBook() {
        library.borrowBook(book1);
        library.returnBook(book1);
        assertEquals(1, library.countBooks());
        assertEquals(0, library.countBorrowedBooks());
    }


    @Test
    //test 6
    public void testAttemptToBorrowAlreadyBorrowedBook() {
        library.borrowBook(book1);  // Borrow the book the first time
        library.borrowBook(book1);  // Attempt to borrow again
        assertEquals(1, library.countBorrowedBooks());  
    }
 
  
}
