package demo;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library("src/database/book.txt");
        Librarian librarian = new Librarian(library);
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("Chào mừng bạn đến với hệ thống quản lý thư viện!");
            System.out.println("Vui lòng nhập vai trò của bạn (1 - Độc giả, 2 - Thủ thư): ");
            int role = scanner.nextInt();

            switch (role) {
                case 1:
                    DisplayReaderMenu r = new DisplayReaderMenu();
                    r.displayReaderMenu(library, scanner);
                    break;
                case 2:
                    DisplayLibrarianMenu l = new DisplayLibrarianMenu();
                    l.displayLibrarianMenu(librarian, scanner);
                    break;
                default:
                    System.out.println("Vai trò không hợp lệ.");
                    break;
            }
        }

        scanner.close();
    }




}
