package storage;

import view.LibrarianLoginView;

import java.util.Scanner;


/**
 * Menu
 */
public class MainView {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("------ Library Management System ------");
        int choice;

        do {
            System.out.println("Choose the role: ");
            System.out.println("1. Librarian");
            System.out.println("2. User");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    LibrarianLoginView librarianLoginView = new LibrarianLoginView();
                    librarianLoginView.librarian(scanner);
                    break;
                case 2:
                    // user(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
}
