package view.user;

import bookManagerment.user.UserValidateLogin;
import model.UserAccount;
import storage.UserReadWriteFile;

import java.util.List;
import java.util.Scanner;

public class PreUserLoginView {
    public static final String FILE_NAME = "src/database/UserAccount.txt";
    public void login(Scanner scanner) {

        List<UserAccount> userAccounts = UserReadWriteFile.readUserAccountFromFile(FILE_NAME);

        System.out.println("------------ USER LOG IN ------------");
        if (UserValidateLogin.checkLogin(FILE_NAME)) {

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
