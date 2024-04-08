package bookManagerment.user;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserManagement {
    private Map<String, Boolean> books;
    private Map<String, String> borrowedBooks;

    public UserManagement() {
        books = new HashMap<>();
        borrowedBooks = new HashMap<>();
    }

    public void writeBorrowedBooksToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, String> entry : borrowedBooks.entrySet()) {
                String bookTitle = entry.getKey();
                String borrower = entry.getValue();
                writer.write(bookTitle + "," + borrower);
                writer.newLine();
            }
            System.out.println("Successfully wrote books to file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error while writing books to file: " + e.getMessage());
        }
    }

    public void readBorrowedBook(String fileName) {
        books = new HashMap<>();
        borrowedBooks = new HashMap<>();
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

    public void borrowBook(String bookTitle, String borrower, String fileName) {
        if (books.containsKey(bookTitle) && books.get(bookTitle)) {
            books.put(bookTitle, false);
            borrowedBooks.put(borrower, bookTitle);
            System.out.println("The user " + borrower + " have successfully borrowed the book '" + bookTitle + "'.");
            writeBorrowedBooksToFile(fileName);
        } else {
            System.out.println("Sorry, the book '" + bookTitle + "' is not available for borrowing.");
        }
    }

    public void returnBook(String bookTitle) {
        if (books.containsKey(bookTitle) && !books.get(bookTitle)) {
            books.put(bookTitle, true);
            borrowedBooks.values().removeIf(value -> value.equals(bookTitle));
            System.out.println("You have successfully returned the book '" + bookTitle + "'.");
        } else {
            System.out.println("Sorry, the book '" + bookTitle + "' cannot be returned as it is not borrowed.");
        }
    }

    public Map<String, String> getBorrowedBooks() {
        return borrowedBooks;
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
