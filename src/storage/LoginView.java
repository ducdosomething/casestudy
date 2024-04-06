package storage;

import bookManagerment.ValidateLogin;
import model.LibrarianAccount;
import view.LibrarianView;

import java.util.List;
import java.util.Scanner;

public class LoginView {
    public void login(Scanner scanner) {

        String fileName = "src/database/LibrarianAccount.txt";
        List<LibrarianAccount> librarianAccounts = LibrarianReadWriteFile.readLibrarianAccountFromFile(fileName);

        System.out.println("------------ Log in ------------");
        if (ValidateLogin.checkLogin(fileName)) {

            LibrarianView librarianView = new LibrarianView();
            librarianView.showLibrarianView();
        }
        System.out.println("Press 0 to return to the main menu.");
        int choice = scanner.nextInt();
        if (choice == 0) {
            return;
        } else {
            System.out.println("Invalid choice. Returning to main menu.");
        }
    }
}

