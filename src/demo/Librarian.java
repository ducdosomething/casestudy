package demo;

import java.util.Map;

public class Librarian {
    private Library library;

    public Librarian(Library library) {
        this.library = library;
    }

    public void displayBorrowedBooks() {
        library.displayBorrowedBooks();
    }
}
