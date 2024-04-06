package storage;

import model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookReadWriteFile {
    public static void writeBooksToFile(List<Book> books, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            for (Book book : books) {
                bw.write(book.getBookId() + "," + book.getName() + "," + book.getPrice() + ","
                        + book.getCategory() + "," + book.getAuthor() + "," + book.getInventoryQuantity());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Book> readBooksFromFile(String fileName) {
        List<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    int bookId = Integer.parseInt(data[0]);
                    String name = data[1];
                    double price = Double.parseDouble(data[2]);
                    String category = data[3];
                    String author = data[4];
                    int inventoryQuantity = Integer.parseInt(data[5]);
                    books.add(new Book(bookId, name, price, category, author, inventoryQuantity));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
}
