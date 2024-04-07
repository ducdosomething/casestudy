package demo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library("src/database/book.txt"); // Truyền tên tệp sách vào constructor
        Librarian librarian = new Librarian(library);
        Scanner scanner = new Scanner(System.in);

        while (true) {System.out.println("Chào mừng bạn đến với hệ thống quản lý thư viện!");
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
                    librarian.displayBorrowedBooks();
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

    public static void displayReaderMenu(Library library, Scanner scanner) {
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
