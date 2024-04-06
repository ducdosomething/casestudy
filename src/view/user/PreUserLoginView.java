package view.user;

import bookManagerment.librarian.LibrarianValidateLogin;
import bookManagerment.user.UserValidateLogin;
import model.LibrarianAccount;
import model.UserAccount;
import storage.LibrarianReadWriteFile;
import storage.UserReadWriteFile;
import view.librarian.LibrarianView;

import java.util.List;
import java.util.Scanner;

public class PreUserLoginView {
    public void login(Scanner scanner) {

        String fileName = "src/database/UserAccount.txt";
        List<UserAccount> userAccounts = UserReadWriteFile.readUserAccountFromFile(fileName);

        System.out.println("------------ Log in ------------");
        if (UserValidateLogin.checkLogin(fileName)) {

            UserView userView = new UserView();
            userView.showUserView();
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
