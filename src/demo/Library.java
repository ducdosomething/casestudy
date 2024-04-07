package demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Library {
    private Map<String, Boolean> books;

    public Library(String filename) {
        books = new HashMap<>();
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

    public void borrowBook(String bookTitle) {
        if (books.containsKey(bookTitle) && books.get(bookTitle)) {
            books.put(bookTitle, false);
            System.out.println("Bạn đã mượn sách '" + bookTitle + "' thành công.");
        } else {
            System.out.println("Xin lỗi, sách '" + bookTitle + "' không có sẵn để mượn.");
        }
    }

    public void returnBook(String bookTitle) {
        if (books.containsKey(bookTitle) && !books.get(bookTitle)) {
            books.put(bookTitle, true);
            System.out.println("Bạn đã trả sách '" + bookTitle + "' thành công.");
        } else {
            System.out.println("Xin lỗi, sách '" + bookTitle + "' không thể trả do không được mượn.");
        }
    }

    public void displayBorrowedBooks() {
        System.out.println("Danh sách sách đã được mượn:");
        for (Map.Entry<String, Boolean> entry : books.entrySet()) {
            if (!entry.getValue()) { // Kiểm tra xem sách đã được mượn (giá trị là false)
                System.out.println("- " + entry.getKey());
            }
        }
    }
}

