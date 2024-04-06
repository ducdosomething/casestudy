package storage;

import model.LibrarianAccount;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibrarianReadWriteFile {
    public static void writeLibrarianAccountToFile(List<LibrarianAccount> librarianAccounts, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            for (LibrarianAccount librarianAccount : librarianAccounts) {
                bw.write(librarianAccount.getiD() + "," +librarianAccount.getUsername() + "," + librarianAccount.getPassword() +
                            "," +  librarianAccount.getAge() + "," + librarianAccount.getGender());
                bw.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static List<LibrarianAccount> readLibrarianAccountFromFile(String fileName) {
        List<LibrarianAccount> librarianAccounts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    int iD = Integer.parseInt(data[0]);
                    String username = data[1];
                    String password = data[2];
                    int age = Integer.parseInt(data[3]);
                    String gender = data[4];
                    librarianAccounts.add(new LibrarianAccount(username, password, iD, age, gender));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing data: " + e.getMessage());
        }
        return librarianAccounts;
    }
}
