package storage;

import model.UserAccount;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserReadWriteFile {

    public static void writeLibrarianAccountToFile(List<UserAccount> userAccounts, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            for (UserAccount userAccount : userAccounts) {
                bw.write(userAccount.getiD() + "," + userAccount.getUsername() + "," + userAccount.getPassword() +
                        "," +  userAccount.getAge() + "," + userAccount.getGender() + "," + userAccount.getAddress() +
                        "," + userAccount.getPhoneNumber() + "," + userAccount.getRegistrationTime());
                bw.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static List<UserAccount> readUserAccountFromFile(String fileName) {
        List<UserAccount> userAccounts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 7) {
                    int iD = Integer.parseInt(data[0]);
                    String username = data[1];
                    String password = data[2];
                    int age = Integer.parseInt(data[3]);
                    String gender = data[4];
                    String address = data[5];
                    String phoneNumber = data[6];
                    LocalDateTime registrationTime = LocalDateTime.parse(data[7]);
                    userAccounts.add(new UserAccount(username, password, iD, age, gender, address, phoneNumber, registrationTime));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing data: " + e.getMessage());
        }
        return userAccounts;
    }
}
