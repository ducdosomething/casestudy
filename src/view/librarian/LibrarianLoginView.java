package view.librarian;

import bookManagerment.librarian.LibrarianValidateLogin;
import storage.LibrarianReadWriteFile;

import java.util.Scanner;

public class LibrarianLoginView {
    public static final String FILE_NAME = "src/database/LibrarianAccount.txt";
    public void librarian(Scanner scanner) {
        LibrarianReadWriteFile librarianReadWriteFile = new LibrarianReadWriteFile();
        librarianReadWriteFile.readLibrarianAccountFromFile(FILE_NAME);
        LibrarianValidateLogin loginSystem = new LibrarianValidateLogin(FILE_NAME);
        System.out.println("------ MANAGEMENT PROGRAM ------");
        int choice;
        do {
            System.out.println("Choose an option: ");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    PreLibLoginView preLibLoginView = new PreLibLoginView();
                    preLibLoginView.login(scanner);
                    break;
                case 2:
                    LibrarianRegisterView librarianRegisterView = new LibrarianRegisterView();
                    librarianRegisterView.register(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        boolean loggedIn = loginSystem.checkLogin(FILE_NAME);
        if (loggedIn) {
            System.out.println("Logged in successfully! Starting management program...");
        } else {
            System.out.println("Exiting program...");
        }
    }
}

