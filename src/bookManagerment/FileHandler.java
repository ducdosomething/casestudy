package bookManagerment;

import model.Book;
import storage.BookReadWriteFile;

import java.io.*;
    import java.util.ArrayList;
    import java.util.List;

public class FileHandler {

    public static void showAllBook(String fileName) {
        List<Book> books = BookReadWriteFile.readBooksFromFile(fileName);
        if (books.isEmpty()) {
            System.out.println("No books available!");
            return;
        }
        System.out.printf("%5s | %20s | %15s | %10s | %20s | %10s \n", "ID", "NAME", "PRICE", "CATEGORY", "AUTHOR",
                "INVENTORYQUANTITY");
        for (Book b : books) {
            System.out.printf("%5d | %20s | %15.2f | %10s | %20s | %10d \n",
                    b.getBookId(), b.getName(), b.getPrice(), b.getCategory(), b.getAuthor(), b.getInventoryQuantity());
        }
    }

        public static void deleteBookFromFile(int bookIdToRemove, String fileName) {
            List<Book> books = BookReadWriteFile.readBooksFromFile(fileName);
            if (books == null) {
                System.out.println("Không thể đọc danh sách sách từ tệp.");
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
                System.out.println("Lỗi khi ghi vào tệp: " + e.getMessage());
                return;
            }

            // Xóa tệp gốc và đổi tên tệp tạm thời thành tên tệp gốc
            java.io.File oldFile = new java.io.File(fileName);
            java.io.File newFile = new java.io.File(fileName + ".tmp");
            if (oldFile.delete()) {
                if (!newFile.renameTo(oldFile)) {
                    System.out.println("Không thể đổi tên tệp tạm thời.");
                } else {
                    System.out.println("Sách đã được xóa khỏi file.");
                }
            } else {
                System.out.println("Không thể xóa tệp gốc.");
            }
        }

        public static void deleteBookByName(String bookNameToRemove, String fileName) {
            List<Book> books = BookReadWriteFile.readBooksFromFile(fileName);
            if (books == null) {
                System.out.println("Không thể đọc danh sách sách từ tệp.");
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
                System.out.println("Lỗi khi ghi vào tệp: " + e.getMessage());
                return;
            }

            java.io.File oldFile = new java.io.File(fileName);
            java.io.File newFile = new java.io.File(fileName + ".tmp");
            if (oldFile.delete()) {
                if (!newFile.renameTo(oldFile)) {
                    System.out.println("Không thể đổi tên tệp tạm thời.");
                } else {
                    System.out.println("Sách đã được xóa khỏi file.");
                }
            } else {
                System.out.println("Không thể xóa tệp gốc.");
            }
        }

        public static List<Book> searchBookByName(String bookNameToSearch, String fileName) {
            List<Book> foundBooks = new ArrayList<>();
            List<Book> books = BookReadWriteFile.readBooksFromFile(fileName);
            if (books == null) {
                System.out.println("Không thể đọc danh sách sách từ tệp.");
                return null;
            }

            bookNameToSearch = bookNameToSearch.trim();

            for (Book book : books) {
                if (book.getName().equalsIgnoreCase(bookNameToSearch)) {
                    foundBooks.add(book);
                }
            }

            if (foundBooks.isEmpty()) {
                System.out.println("Không tìm thấy sách có tên '" + bookNameToSearch + "'.");
            }

            return foundBooks;
        }

        public static List<Book> searchBookByCategory(String categoryNameToSearch, String fileName) {
            List<Book> foundCategorys = new ArrayList<>();
            List<Book> books = BookReadWriteFile.readBooksFromFile(fileName);
            if (books == null) {
                System.out.println("Không thể đọc danh sách sách từ tệp.");
                return null;
            }

            categoryNameToSearch = categoryNameToSearch.trim();

            for (Book book : books) {
                if (book.getCategory().equalsIgnoreCase(categoryNameToSearch)) {
                    foundCategorys.add(book);
                }
            }

            if (foundCategorys.isEmpty()) {
                System.out.println("Không tìm thấy sách có thể loại '" + categoryNameToSearch + "'.");
            }

            return foundCategorys;
        }
    }

