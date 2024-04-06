package view;

import bookManagerment.ValidateRegister;
import model.LibrarianAccount;
import storage.LibrarianReadWriteFile;

import java.util.List;
import java.util.Scanner;

public class RegisterView {
    public void register(Scanner scanner) {

        String fileName = "src/database/LibrarianAccount.txt";
        List<LibrarianAccount> librarianAccounts = LibrarianReadWriteFile.readLibrarianAccountFromFile(fileName);

        System.out.println("----------- Register -----------");
        ValidateRegister.checkRegistration(fileName, librarianAccounts);
        System.out.println("Press 0 to return to the main menu.");
        int choice = scanner.nextInt();
        if (choice == 0) {
            return;
        } else {
            System.out.println("Invalid choice. Returning to main menu.");
        }
    }
}
