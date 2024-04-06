package view.user;

import bookManagerment.FileHandler;
import model.Book;
import storage.BookReadWriteFile;

import java.util.List;
import java.util.Scanner;

public class UserView {
    public void showUserView() {
        Scanner scanner = new Scanner(System.in);
        String fileName = "src/database/book.txt";

        while (true) {
            System.out.println("------- MENU -------");
            System.out.println("1. Xem thông tin tất cả sách từ file");
            System.out.println("2. Tìm sách từ file theo tên");
            System.out.println("3. Tìm sách từ file theo thể loại");
            System.out.println("4. Thoát");
            System.out.print("Chọn một tùy chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Danh sách sách từ file:");
                    FileHandler.showAllBook(fileName);
                    break;
                case 2:
                    System.out.print("Nhập tên sách cần tìm: ");
                    String bookNameToSearch = scanner.nextLine();
                    List<Book> foundBooks = FileHandler.searchBookByName(bookNameToSearch, fileName);
                    if (foundBooks != null) {
                        System.out.println("Kết quả tìm kiếm:");
                        for (Book book : foundBooks) {
                            System.out.println(book);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nhập thể loại sách cần tìm: ");
                    String categoryNameToSearch = scanner.nextLine();
                    List<Book> foundCategorys = FileHandler.searchBookByCategory(categoryNameToSearch, fileName);
                    if (foundCategorys != null) {
                        System.out.println("Kết quả tìm kiếm:");
                        for (Book book : foundCategorys) {
                            System.out.println(book);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Ứng dụng đã kết thúc.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    public static Book readBookFromInput(Scanner scanner) {
        System.out.print("ID của sách: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Tên sách: ");
        String name = scanner.nextLine();

        System.out.print("Giá sách: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Thể loại sách: ");
        String category = scanner.nextLine();

        System.out.print("Tác giả: ");
        String author = scanner.nextLine();

        System.out.print("Số lượng tồn kho: ");
        int inventoryQuantity = scanner.nextInt();
        scanner.nextLine();

        return new Book(bookId, name, price, category, author, inventoryQuantity);
    }
}
