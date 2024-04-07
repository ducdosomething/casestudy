package demo;

import java.util.Scanner;

public class DisplayLibrarianMenu {
    public void displayLibrarianMenu(Librarian librarian, Scanner scanner) {
        while (true) {
            System.out.println("Menu cho thủ thư:");
            System.out.println("1. Hiển thị danh sách sách đã được mượn");
            System.out.println("2. Thoát");
            System.out.println("Vui lòng chọn một chức năng (1-2): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    librarian.displayBorrowedBooks();
                    break;
                case 2:
                    System.out.println("Đã thoát.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        }
    }
}
