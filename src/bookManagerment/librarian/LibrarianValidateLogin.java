package bookManagerment.librarian;

import model.LibrarianAccount;
import storage.LibrarianReadWriteFile;

import java.util.List;
import java.util.Scanner;

public class LibrarianValidateLogin {
    private List<LibrarianAccount> librarians;

    public LibrarianValidateLogin(String fileName) {
        librarians = LibrarianReadWriteFile.readLibrarianAccountFromFile(fileName);
    }

    public boolean authenticate(String username, String password) {
        for (LibrarianAccount librarian : librarians) {
            if (librarian.getUsername().equals(username) && librarian.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkLogin(String fileName) {
        LibrarianValidateLogin librarianValidateLogin = new LibrarianValidateLogin(fileName);
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

            if (librarianValidateLogin.authenticate(username, password)) {
                System.out.println("Login successful!");
                return true;
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }
    }
}
