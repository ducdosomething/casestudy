package view.user;

import bookManagerment.librarian.LibrarianManagement;
import bookManagerment.user.UserManagement;
import model.Book;

import java.util.List;
import java.util.Scanner;

public class UserView {
    public static final String FIELD_NAME = "src/database/book.txt";
    public void showUserView() {
        Scanner scanner = new Scanner(System.in);
        //String fileName = FIELD_NAME;
        UserManagement userManagement = new UserManagement();
        userManagement.readBorrowedBook(FIELD_NAME);

        while (true) {
            System.out.println("------- USER MENU -------");
            System.out.println("1. View information of all books from the file");
            System.out.println("2. Find book from file by name");
            System.out.println("3. Find book from file by category");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Display list of borrowed books");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("List of books from the file:");
                    LibrarianManagement.showAllBook(FIELD_NAME);
                    break;
                case 2:
                    System.out.print("Enter the name of the book you want to find: ");
                    String bookNameToSearch = scanner.nextLine();
                    List<Book> foundBooks = LibrarianManagement.searchBookByName(bookNameToSearch, FIELD_NAME);
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
                    List<Book> foundCategorys = LibrarianManagement.searchBookByCategory(categoryNameToSearch, FIELD_NAME);
                    if (foundCategorys != null) {
                        System.out.println("Search result:");
                        for (Book book : foundCategorys) {
                            System.out.println(book);
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter the name of the book you want to borrow: ");
                    String borrowBookTitle = scanner.nextLine();
                    userManagement.borrowBook(borrowBookTitle);
                    break;
                case 5:
                    System.out.print("Enter the name of the book you want to return: ");
                    String returnBookTitle = scanner.nextLine();
                    userManagement.returnBook(returnBookTitle);
                    break;
                case 6:
                    userManagement.displayBorrowedBooks();
                    break;
                case 7:
                    System.out.println("The application has ended.");
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
