package view.librarian;

import bookManagerment.librarian.LibrarianManagement;
import model.Book;
import storage.BookReadWriteFile;

import java.util.Scanner;
import java.util.List;

public class LibrarianView {
    public static final String FILE_NAME = "src/database/book.txt";
    public static final String FILE_NAME2 = "src/database/borrowedBook.txt";
    public static final String FILE_USER = "src/database/UserAccount.txt";

    public void showLibrarianView() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------- LIBRARIAN MENU -------");
            System.out.println("1. Read book information from file");
            System.out.println("2. Write book information to file");
            System.out.println("3. Delete book from file by ID");
            System.out.println("4. Delete book from file by name");
            System.out.println("5. Find book from file by name");
            System.out.println("6. Find book from file by genre");
            System.out.println("7. Find book from file by author");
            System.out.println("8. View all reader accounts in the system");
            System.out.println("9. View the list of borrowed books.");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");


            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("List of books: ");
                    LibrarianManagement.showAllBook(FILE_NAME);
                    break;
                case 2:
                    System.out.println("Enter an information of the book: ");
                    Book newBook = readBookFromInput(scanner);
                    BookReadWriteFile.writeBooksToFile(List.of(newBook), FILE_NAME);
                    System.out.println("Book information has been written to the file.");
                    break;
                case 3:
                    System.out.print("Enter the ID of the book you want to delete: ");
                    int bookIdToRemove = scanner.nextInt();
                    scanner.nextLine();
                    LibrarianManagement.deleteBookFromFile(bookIdToRemove, FILE_NAME);
                    System.out.println("The book has been deleted from the file.");
                    break;
                case 4:
                    System.out.print("Enter the name of the book you want to delete: ");
                    String bookNameToDelete = scanner.nextLine();
                    LibrarianManagement.deleteBookByName(bookNameToDelete, FILE_NAME);
                    System.out.println("The book has been deleted from the file.");
                    break;
                case 5:
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
                case 6:
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
                case 7:
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
                case 8:
                    System.out.println("List of user accounts:");
                    LibrarianManagement.showAllUsersAccount(FILE_USER);
                    break;
                case 9:
                    System.out.println("List of borrowed books:");
                    LibrarianManagement.showBorrowedBooksList(FILE_NAME2);
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

        System.out.print("Inventory quantity: ");
        int inventoryQuantity = scanner.nextInt();
        scanner.nextLine();

        return new Book(bookId, name, price, category, author, inventoryQuantity);
    }
}