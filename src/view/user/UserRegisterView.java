package view.user;

import bookManagerment.user.UserValidateRegister;
import model.UserAccount;
import storage.UserReadWriteFile;

import java.util.List;
import java.util.Scanner;

public class UserRegisterView {
    public static final String FILE_NAME = "src/database/UserAccount.txt";
    public void register(Scanner scanner) {

        List<UserAccount> userAccounts = UserReadWriteFile.readUserAccountFromFile(FILE_NAME);

        System.out.println("----------- USER REGISTER -----------");
        UserValidateRegister.checkRegistration(FILE_NAME, userAccounts);
        System.out.println("Press 0 to return to the main menu.");
        int choice = scanner.nextInt();
        if (choice == 0) {
            return;
        } else {
            System.out.println("Invalid choice. Returning to main menu.");
        }
    }
}
