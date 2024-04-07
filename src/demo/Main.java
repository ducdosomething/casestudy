package demo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library("src/database/book.txt"); // Truyền tên tệp sách vào constructor
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Chào mừng bạn đến với hệ thống quản lý thư viện!");
            System.out.println("1. Mượn sách");
            System.out.println("2. Trả sách");
            System.out.println("3. Hiển thị danh sách sách đã được mượn");
            System.out.println("4. Thoát");
            System.out.print("Vui lòng chọn một chức năng (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Đọc bỏ ký tự newline
                    System.out.print("Nhập tên sách bạn muốn mượn: ");
                    String borrowBookTitle = scanner.nextLine();
                    library.borrowBook(borrowBookTitle);
                    break;
                case 2:
                    scanner.nextLine(); // Đọc bỏ ký tự newline
                    System.out.print("Nhập tên sách bạn muốn trả: ");
                    String returnBookTitle = scanner.nextLine();
                    library.returnBook(returnBookTitle);
                    break;
                case 3:
                    library.displayBorrowedBooks();
                    break;
                case 4:
                    System.out.println("Cảm ơn bạn đã sử dụng hệ thống quản lý thư viện.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Vui lòng chọn một số từ 1 đến 4.");
            }
        }
    }
}
