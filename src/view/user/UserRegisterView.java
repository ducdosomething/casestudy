package view.user;

import bookManagerment.user.UserValidateRegister;
import model.UserAccount;
import storage.UserReadWriteFile;

import java.util.List;
import java.util.Scanner;

public class UserRegisterView {
    public void register(Scanner scanner) {

        String fileName = "src/database/UserAccount.txt";
        List<UserAccount> userAccounts = UserReadWriteFile.readUserAccountFromFile(fileName);

        System.out.println("----------- USER REGISTER -----------");
        UserValidateRegister.checkRegistration(fileName, userAccounts);
        System.out.println("Press 0 to return to the main menu.");
        int choice = scanner.nextInt();
        if (choice == 0) {
            return;
        } else {
            System.out.println("Invalid choice. Returning to main menu.");
        }
    }
}
