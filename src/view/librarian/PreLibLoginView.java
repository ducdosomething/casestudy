package view.librarian;

import bookManagerment.librarian.LibrarianValidateLogin;
import model.LibrarianAccount;
import storage.LibrarianReadWriteFile;

import java.util.List;
import java.util.Scanner;

public class PreLibLoginView {
    public static final String FILE_NAME = "src/database/LibrarianAccount.txt";
    public void login(Scanner scanner) {

        List<LibrarianAccount> librarianAccounts = LibrarianReadWriteFile.readLibrarianAccountFromFile(FILE_NAME);

        System.out.println("------------ LIBRARIAN LOG IN ------------");
        if (LibrarianValidateLogin.checkLogin(FILE_NAME)) {

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

