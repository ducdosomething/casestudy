package bookManagerment.user;

import model.LibrarianAccount;
import model.UserAccount;
import view.librarian.PreLibLoginView;
import view.user.PreUserLoginView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidateRegister {
    public static void registerUser(String fileName, int iD, String username, String password, int age, String gender, String address, String phoneNumber) {
        LocalDateTime registrationTime = LocalDateTime.now();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            if (new File(fileName).length() > 0) {
                writer.newLine();
            }
            writer.write(iD + "," +username + "," + password + "," + age + "," + gender + "," + address + "," + phoneNumber);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void checkRegistration(String fileName, List<UserAccount> userAccounts) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Would you like to register a new account? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                return;
            } else if (response.equalsIgnoreCase("yes")) {
                while (true) {
                    System.out.println("Enter your ID: ");
                    int newId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter your username: ");
                    String newUsername = scanner.nextLine();

                    if (!isValidUsername(newUsername)) {
                        System.out.println("Username is invalid, please try again!");
                        continue;
                    }

                    while (true) {
                        System.out.print("Enter your password: ");
                        String newPassword = scanner.nextLine();

                        if (!isValidPassword(newPassword)) {
                            System.out.println("Password is invalid,please try again!");
                            continue;
                        }
                        System.out.println("Enter your age: ");
                        int newAge = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter your gender: ");
                        String newGender = scanner.nextLine();
                        System.out.println("Enter your address: ");
                        String newAddress = scanner.nextLine();
                        System.out.println("Enter your phone number: ");
                        String newPhoneNumber = scanner.nextLine();

                        registerUser(fileName, newId, newUsername, newPassword, newAge, newGender, newAddress, newPhoneNumber);

                        System.out.println("Registration successful!");
                        PreUserLoginView preUserLoginView = new PreUserLoginView();
                        preUserLoginView.login(scanner);
                        break;
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
