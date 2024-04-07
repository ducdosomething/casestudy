package bookManagerment;

import model.Book;
import model.UserAccount;
import storage.BookReadWriteFile;
import storage.UserReadWriteFile;

import java.io.*;
    import java.util.ArrayList;
    import java.util.List;

public class FileHandler {

    public static void showAllUsersAccount(String fileUser) {
        List<UserAccount> userAccounts = UserReadWriteFile.readUserAccountFromFile(fileUser);
        if (userAccounts.isEmpty()) {
            System.out.println("There are no user accounts");
            return;
        }
        System.out.printf("%5s | %20s | %15s | %10s | %20s | %10s | %15s \n", "ID", "USERNAME", "PASSWORD", "AGE", "GENDER",
                "ADDRESS", "PHONE NUMBER");
        for (UserAccount u : userAccounts) {
            System.out.printf("%5d | %20s | %15s | %10d | %20s | %10s | %15s \n",
                    u.getiD(), u.getUsername(), u.getPassword(), u.getAge(), u.getGender(), u.getAddress(), u.getPhoneNumber());
        }
    }

    public static void showAllBook(String fileName) {
        List<Book> books = BookReadWriteFile.readBooksFromFile(fileName);
        if (books.isEmpty()) {
            System.out.println("No books available!");
            return;
        }
        System.out.printf("%5s | %20s | %15s | %10s | %20s | %10s \n", "ID", "NAME", "PRICE", "CATEGORY", "AUTHOR",
                "INVENTORY QUANTITY");
        for (Book b : books) {
            System.out.printf("%5d | %20s | %15.2f | %10s | %20s | %10d \n",
                    b.getBookId(), b.getName(), b.getPrice(), b.getCategory(), b.getAuthor(), b.getInventoryQuantity());
        }
    }

        public static void deleteBookFromFile(int bookIdToRemove, String fileName) {
            List<Book> books = BookReadWriteFile.readBooksFromFile(fileName);
            if (books == null) {
                System.out.println("Unable to read the list of books from the file.");
                return;
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName + ".tmp"))) {
                for (Book book : books) {
                    if (book.getBookId() != bookIdToRemove) {
                        bw.write(book.getBookId() + "," + book.getName() + "," + book.getPrice() + ","
                                + book.getCategory() + "," + book.getAuthor() + "," + book.getInventoryQuantity());
                        bw.newLine();
                    }
                }
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
                return;
            }

            java.io.File oldFile = new java.io.File(fileName);
            java.io.File newFile = new java.io.File(fileName + ".tmp");
            if (oldFile.delete()) {
                if (!newFile.renameTo(oldFile)) {
                    System.out.println("Unable to rename temporary file.");
                } else {
                    System.out.println("The book has been deleted from the file.");
                }
            } else {
                System.out.println("Unable to delete the original file.");
            }
        }

        public static void deleteBookByName(String bookNameToRemove, String fileName) {
            List<Book> books = BookReadWriteFile.readBooksFromFile(fileName);
            if (books == null) {
                System.out.println("Unable to read the list of books from the file.");
                return;
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName + ".tmp"))) {
                for (Book book : books) {
                    if (!book.getName().equals(bookNameToRemove)) {
                        bw.write(book.getBookId() + "," + book.getName() + "," + book.getPrice() + ","
                                + book.getCategory() + "," + book.getAuthor() + "," + book.getInventoryQuantity());
                        bw.newLine();
                    }
                }
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
                return;
            }

            java.io.File oldFile = new java.io.File(fileName);
            java.io.File newFile = new java.io.File(fileName + ".tmp");
            if (oldFile.delete()) {
                if (!newFile.renameTo(oldFile)) {
                    System.out.println("Unable to rename temporary file.");
                } else {
                    System.out.println("The book has been deleted from the file.");
                }
            } else {
                System.out.println("Unable to delete the original file.");
            }
        }

        public static List<Book> searchBookByName(String bookNameToSearch, String fileName) {
            List<Book> foundBooks = new ArrayList<>();
            List<Book> books = BookReadWriteFile.readBooksFromFile(fileName);
            if (books == null) {
                System.out.println("Unable to read the list of books from the file.");
                return null;
            }

            bookNameToSearch = bookNameToSearch.trim();

            for (Book book : books) {
                if (book.getName().equalsIgnoreCase(bookNameToSearch)) {
                    foundBooks.add(book);
                }
            }

            if (foundBooks.isEmpty()) {
                System.out.println("No book found with the name '" + bookNameToSearch + "'.");
            }

            return foundBooks;
        }

        public static List<Book> searchBookByCategory(String categoryNameToSearch, String fileName) {
            List<Book> foundCategorys = new ArrayList<>();
            List<Book> books = BookReadWriteFile.readBooksFromFile(fileName);
            if (books == null) {
                System.out.println("Unable to read the list of books from the file.");
                return null;
            }

            categoryNameToSearch = categoryNameToSearch.trim();

            for (Book book : books) {
                if (book.getCategory().equalsIgnoreCase(categoryNameToSearch)) {
                    foundCategorys.add(book);
                }
            }

            if (foundCategorys.isEmpty()) {
                System.out.println("No books found with the specified genre. '" + categoryNameToSearch + "'.");
            }

            return foundCategorys;
        }
    }

