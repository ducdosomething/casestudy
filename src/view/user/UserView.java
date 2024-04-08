package view.user;

import bookManagerment.librarian.LibrarianManagement;
import bookManagerment.user.UserManagement;
import model.Book;

import java.util.List;
import java.util.Scanner;

public class UserView {
    public static final String FILE_NAME = "src/database/book.txt";
    public static final String FILE_NAME2 = "src/database/borrowedBook.txt";
    public void showUserView() {
        Scanner scanner = new Scanner(System.in);
        UserManagement userManagement = new UserManagement();
        userManagement.readBorrowedBook(FILE_NAME);

        while (true) {
            System.out.println("------- USER MENU -------");
            System.out.println("1. View information of all books from the file");
            System.out.println("2. Find book from file by name");
            System.out.println("3. Find book from file by category");
            System.out.println("4. Find book from file by author");
            System.out.println("5. Borrow a book");
            System.out.println("6. Return a book");
            System.out.println("7. Display list of borrowed books");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("List of books from the file:");
                    LibrarianManagement.showAllBook(FILE_NAME);
                    break;
                case 2:
                    System.out.print("Enter the name of the book you want to find: ");
                    String bookNameToSearch = scanner.nextLine();
                    List<Book> foundBooks = LibrarianManagement.searchBookByName(bookNameToSearch, FILE_NAME);
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
                    List<Book> foundCategorys = LibrarianManagement.searchBookByCategory(categoryNameToSearch, FILE_NAME);
                    if (foundCategorys != null) {
                        System.out.println("Search result:");
                        for (Book book : foundCategorys) {
                            System.out.println(book);
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter the author of the book you want to find: ");
                    String authorToSearch = scanner.nextLine();
                    List<Book> foundAuthors = LibrarianManagement.searchBookByAuthor(authorToSearch, FILE_NAME);
                    if (foundAuthors != null) {
                        System.out.println("Search result:");
                        for (Book book : foundAuthors) {
                            System.out.println(book);
                        }
                    }
                    break;
                case 5:
                    System.out.print("Enter the name of the book you want to borrow: ");
                    String borrowBookTitle = scanner.nextLine();
                    System.out.print("Enter your username: ");
                    String borrower = scanner.nextLine();
                    userManagement.borrowBook(borrowBookTitle, borrower, FILE_NAME2);
                    break;
                case 6:
                    System.out.print("Enter the name of the book you want to return: ");
                    String returnBookTitle = scanner.nextLine();
                    userManagement.returnBook(returnBookTitle);
                    break;
                case 7:
                    userManagement.displayBorrowedBooks();
                    break;
                case 0:
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
