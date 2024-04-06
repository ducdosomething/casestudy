package view;

import bookManagerment.FileHandler;
import model.Book;
import storage.BookReadWriteFile;

import java.util.Scanner;
import java.util.List;

public class LibrarianView {
    public void showLibrarianView() {
        Scanner scanner = new Scanner(System.in);
        String fileName = "src/database/book.txt"; // Tên tệp mặc định

        while (true) {
            System.out.println("------- MENU -------");
            System.out.println("1. Đọc thông tin sách từ file");
            System.out.println("2. Ghi thông tin sách vào file");
            System.out.println("3. Xóa sách từ file theo ID");
            System.out.println("4. Xóa sách từ file theo tên");
            System.out.println("5. Tìm sách từ file theo tên");
            System.out.println("6. Tìm sách từ file theo thể loại");
            System.out.println("7. Thoát");
            System.out.print("Chọn một tùy chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.println("Danh sách sách từ file:");
                    FileHandler.showAllBook(fileName); // Gọi phương thức showAllBook với đường dẫn tệp
                    break;
                case 2:
                    System.out.println("Nhập thông tin sách:");
                    Book newBook = readBookFromInput(scanner);
                    BookReadWriteFile.writeBooksToFile(List.of(newBook), fileName);
                    System.out.println("Thông tin sách đã được ghi vào file.");
                    break;
                case 3:
                    System.out.print("Nhập ID sách cần xóa: ");
                    int bookIdToRemove = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    FileHandler.deleteBookFromFile(bookIdToRemove, fileName);
                    System.out.println("Sách đã được xóa khỏi file.");
                    break;
                case 4:
                    System.out.print("Nhập tên sách cần xóa: ");
                    String bookNameToDelete = scanner.nextLine();
                    FileHandler.deleteBookByName(bookNameToDelete, fileName);
                    break;
                case 5:
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
                case 6:
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
                case 7:
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
        scanner.nextLine(); // Consume newline character

        System.out.print("Tên sách: ");
        String name = scanner.nextLine();

        System.out.print("Giá sách: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        System.out.print("Thể loại sách: ");
        String category = scanner.nextLine();

        System.out.print("Tác giả: ");
        String author = scanner.nextLine();

        System.out.print("Số lượng tồn kho: ");
        int inventoryQuantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        return new Book(bookId, name, price, category, author, inventoryQuantity);
    }
}