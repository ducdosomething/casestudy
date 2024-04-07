package demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Library {
    private Map<String, Boolean> books;
    private Map<String, String> borrowedBooks;

    public Library(String filename) {
        books = new HashMap<>();
        borrowedBooks = new HashMap<>();
        // Đọc thông tin sách từ tệp văn bản
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Tách thông tin từng cuốn sách dựa trên dấu phẩy
                String[] bookInfo = line.split(",");
                if (bookInfo.length >= 2) {
                    // Lấy tên sách (cột thứ 2 trong mảng bookInfo)
                    String bookTitle = bookInfo[1];
                    // Mặc định là sách có sẵn khi đọc từ tệp
                    books.put(bookTitle, true);
                }
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc tệp sách: " + e.getMessage());
        }
    }

    public void borrowBook(String bookTitle, String borrower) {
        if (books.containsKey(bookTitle) && books.get(bookTitle)) {
            books.put(bookTitle, false);
            borrowedBooks.put(borrower, bookTitle);
            System.out.println("Bạn " + borrower + " đã mượn sách '" + bookTitle + "' thành công.");
        } else {
            System.out.println("Xin lỗi, sách '" + bookTitle + "' không có sẵn để mượn.");
        }
    }

    public void returnBook(String bookTitle, String borrower) {
        if (books.containsKey(bookTitle) && !books.get(bookTitle) && borrowedBooks.containsKey(borrower) && borrowedBooks.get(borrower).equals(bookTitle)) {
            books.put(bookTitle, true);
            borrowedBooks.remove(borrower);
            System.out.println("Bạn " + borrower + " đã trả sách '" + bookTitle + "' thành công.");
        } else {
            System.out.println("Xin lỗi, sách '" + bookTitle + "' không thể trả do không được mượn bởi " + borrower + ".");
        }
    }

    public Map<String, String> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void displayBorrowedBooks() {
        System.out.println("Danh sách sách đã được mượn:");
        for (Map.Entry<String, String> entry : borrowedBooks.entrySet()) {
            System.out.println("- " + entry.getKey() + " đã mượn sách '" + entry.getValue() + "'.");
        }
    }
}

