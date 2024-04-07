package view.user;

import bookManagerment.user.UserValidateLogin;
import storage.UserReadWriteFile;
import view.librarian.LibrarianRegisterView;
import view.librarian.PreLibLoginView;

import java.util.Scanner;

public class UserLoginView {
    public static final String FILE_NAME = "src/database/UserAccount.txt";

    public void user(Scanner scanner) {
        UserReadWriteFile userReadWriteFile = new UserReadWriteFile();
        userReadWriteFile.readUserAccountFromFile(FILE_NAME);
        UserValidateLogin loginSystem = new UserValidateLogin(FILE_NAME);
        System.out.println("------ USER PROGRAM ------");
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
                    PreUserLoginView preUserLoginView = new PreUserLoginView();
                    preUserLoginView.login(scanner);
                    break;
                case 2:
                    UserRegisterView userRegisterView = new UserRegisterView();
                    userRegisterView.register(scanner);
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
