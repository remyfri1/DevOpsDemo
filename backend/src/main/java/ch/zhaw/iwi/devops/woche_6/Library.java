package ch.zhaw.iwi.devops.woche_6;
//added for Sonic Qube
import java.util.Comparator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Book> borrowedBooks = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

// new with test 9
   public List<Book> searchByTitle(String title) {
    return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
}


    public List<Book> searchByAuthor(String author) {
        return books.stream().filter(book -> book.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toList());
    }

    public void borrowBook(Book book) {
        if (books.contains(book)) {
            books.remove(book);
            borrowedBooks.add(book);
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            books.add(book);
        }
    }

    public int countBooks() {
        return books.size();
    }

    public int countBorrowedBooks() {
        return borrowedBooks.size();
    }

    public boolean removeBook(Book book) {
        boolean removedFromAvailable = books.remove(book);
        boolean removedFromBorrowed = borrowedBooks.remove(book);
        return removedFromAvailable || removedFromBorrowed; 
    }


}
