package bookManagerment;

import model.LibrarianAccount;
import storage.LibrarianReadWriteFile;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateRegister {
    public static void checkRegistration(String fileName, List<LibrarianAccount> librarianAccounts) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Would you like to register a new account? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                return;
            } else if (response.equalsIgnoreCase("yes")) {
                while (true) {
                    System.out.print("Enter your new username: ");
                    String newUsername = scanner.nextLine();

                    if (!isValidUsername(newUsername)) {
                        System.out.println("Username is invalid, please try again!");
                        continue;
                    }

                    while (true) {
                        System.out.print("Enter your new password: ");
                        String newPassword = scanner.nextLine();

                        if (!isValidPassword(newPassword)) {
                            System.out.println("Password is invalid,please try again!");
                            continue;
                        }

                        LibrarianReadWriteFile.writeLibrarianAccountToFile(librarianAccounts, fileName);
                        System.out.println("Registration successful!");
//                        LoginView loginView = new LoginView();
//                        loginView.login(scanner);
//                        break;
                    }
                }
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }

    private static boolean isValidUsername(String username) {
        String regex = "^[A-Z][a-zA-Z0-9]*\\d.*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    private static boolean isValidPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
