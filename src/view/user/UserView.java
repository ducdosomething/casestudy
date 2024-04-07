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
            System.out.println("------- USER MENU -------");
            System.out.println("1. View information of all books from the file");
            System.out.println("2. Find book from file by name");
            System.out.println("3. Find book from file by category");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("List of books from the file:");
                    FileHandler.showAllBook(fileName);
                    break;
                case 2:
                    System.out.print("Enter the name of the book you want to find: ");
                    String bookNameToSearch = scanner.nextLine();
                    List<Book> foundBooks = FileHandler.searchBookByName(bookNameToSearch, fileName);
                    if (foundBooks != null) {
                        System.out.println("Search result:");
                        for (Book book : foundBooks) {
                            System.out.println(book);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter the genre of the book you want to find: ");
                    String categoryNameToSearch = scanner.nextLine();
                    List<Book> foundCategorys = FileHandler.searchBookByCategory(categoryNameToSearch, fileName);
                    if (foundCategorys != null) {
                        System.out.println("Search result:");
                        for (Book book : foundCategorys) {
                            System.out.println(book);
                        }
                    }
                    break;
                case 4:
                    System.out.println("The application has ended.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    public static Book readBookFromInput(Scanner scanner) {
        System.out.print("Book ID ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Book name: ");
        String name = scanner.nextLine();

        System.out.print("Book price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Book category: ");
        String category = scanner.nextLine();

        System.out.print("Author: ");
        String author = scanner.nextLine();

        System.out.print("Inventory Quantity: ");
        int inventoryQuantity = scanner.nextInt();
        scanner.nextLine();

        return new Book(bookId, name, price, category, author, inventoryQuantity);
    }
}
