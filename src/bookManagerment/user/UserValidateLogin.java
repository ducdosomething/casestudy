package bookManagerment.user;

import bookManagerment.librarian.LibrarianValidateLogin;
import model.LibrarianAccount;
import model.UserAccount;
import storage.LibrarianReadWriteFile;
import storage.UserReadWriteFile;

import java.util.List;
import java.util.Scanner;

public class UserValidateLogin {
    private List<UserAccount> users;

    public UserValidateLogin(String fileName) {
        users = UserReadWriteFile.readUserAccountFromFile(fileName);
    }

    public boolean authenticate(String username, String password) {
        for (UserAccount user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkLogin(String fileName) {
        UserValidateLogin userValidateLogin = new UserValidateLogin(fileName);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your username (or 'exit' to quit): ");
            String username = scanner.nextLine();
            if (username.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                return false;
            }

            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            if (userValidateLogin.authenticate(username, password)) {
                System.out.println("Login successful!");
                return true;
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }
    }
}
