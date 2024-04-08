package model;

public class BorrowedBook {
    private String username;
    private String bookTitle;

    public BorrowedBook() {
    }

    public BorrowedBook(String username, String bookTitle) {
        this.username = username;
        this.bookTitle = bookTitle;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Override
    public String toString() {
        return "borrowedBook{" +
                "username='" + username + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                '}';
    }
}
