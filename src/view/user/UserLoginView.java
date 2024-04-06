package view.user;

import storage.UserReadWriteFile;

import java.util.Scanner;

public class UserLoginView {

    public void user(Scanner scanner) {
        String fileName = "src/database/UserAccount";
        UserReadWriteFile userReadWriteFile = new UserReadWriteFile();
        userReadWriteFile.readUserAccountFromFile(fileName);
        UserValidateLogin loginSystem = new UserValidateLogin(fileName);
    }

}
