package view.librarian;

import bookManagerment.librarian.LibrarianValidateLogin;
import model.LibrarianAccount;
import storage.LibrarianReadWriteFile;

import java.util.List;
import java.util.Scanner;

public class PreLibLoginView {
    public void login(Scanner scanner) {

        String fileName = "src/database/LibrarianAccount.txt";
        List<LibrarianAccount> librarianAccounts = LibrarianReadWriteFile.readLibrarianAccountFromFile(fileName);

        System.out.println("------------ Log in ------------");
        if (LibrarianValidateLogin.checkLogin(fileName)) {

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

