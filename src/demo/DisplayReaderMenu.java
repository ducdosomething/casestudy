package demo;

import java.util.Scanner;

public class DisplayReaderMenu {
    public void displayReaderMenu(Library library, Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Menu cho độc giả:");
            System.out.println("1. Mượn sách");
            System.out.println("2. Trả sách");
            System.out.println("3. Thoát");
            System.out.println("Vui lòng chọn một chức năng (1-3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Đọc bỏ ký tự newline
                    System.out.print("Nhập tên sách bạn muốn mượn: ");
                    String borrowBookTitle = scanner.nextLine();
                    System.out.print("Nhập tên người mượn: ");
                    String borrower = scanner.nextLine();
                    library.borrowBook(borrowBookTitle, borrower);
                    break;
                case 2:
                    scanner.nextLine(); // Đọc bỏ ký tự newline
                    System.out.print("Nhập tên sách bạn muốn trả: ");
                    String returnBookTitle = scanner.nextLine();
                    System.out.print("Nhập tên người mượn: ");
                    String returnBorrower = scanner.nextLine();
                    library.returnBook(returnBookTitle, returnBorrower);
                    break;
                case 3:
                    System.out.println("Đã thoát.");
                    exit = true;
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }

        }
    }
}
