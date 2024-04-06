package view;

import bookManagerment.ValidateLogin;
import storage.LibrarianReadWriteFile;
import storage.LoginView;
import storage.RegisterView;

import java.util.Scanner;

public class LibrarianLoginView {
    public void librarian(Scanner scanner) {
        String fileName = "src/database/LibrarianAccount.txt";
        LibrarianReadWriteFile librarianReadWriteFile = new LibrarianReadWriteFile();
        librarianReadWriteFile.readLibrarianAccountFromFile(fileName);
        ValidateLogin loginSystem = new ValidateLogin(fileName);
        System.out.println("------ Management program ------");
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
                    LoginView loginView = new LoginView();
                    loginView.login(scanner);
                    break;
                case 2:
                    RegisterView registerView = new RegisterView();
                    registerView.register(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        boolean loggedIn = loginSystem.checkLogin(fileName);
        if (loggedIn) {
            System.out.println("Logged in successfully! Starting management program...");
        } else {
            System.out.println("Exiting program...");
        }
    }
}

