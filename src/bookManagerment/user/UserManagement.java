package bookManagerment.user;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserManagement {
    private Map<String, Boolean> books;

    public void readBorrowedBook(String fileName) {
        books = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] bookInfo = line.split(",");
                if (bookInfo.length >= 2) {
                    String bookTitle = bookInfo[1];
                    books.put(bookTitle, true);
                }
            }
        } catch (IOException e) {
            System.err.println("Error while reading book file " + e.getMessage());
        }
    }

    public void borrowBook(String bookTitle) {
        if (books.containsKey(bookTitle) && books.get(bookTitle)) {
            books.put(bookTitle, false);
            System.out.println("You have successfully borrowed the book '" + bookTitle + "'.");
        } else {
            System.out.println("Sorry, the book '" + bookTitle + "' is not available for borrowing.");
        }
    }

    public void returnBook(String bookTitle) {
        if (books.containsKey(bookTitle) && !books.get(bookTitle)) {
            books.put(bookTitle, true);
            System.out.println("You have successfully returned the book '" + bookTitle + "'.");
        } else {
            System.out.println("Sorry, the book '" + bookTitle + "' cannot be returned as it is not borrowed.");
        }
    }

    public void displayBorrowedBooks() {
        System.out.println("List of borrowed books:");
        for (Map.Entry<String, Boolean> entry : books.entrySet()) {
            if (!entry.getValue()) {
                System.out.println("- " + entry.getKey());
            }
        }
    }
}
