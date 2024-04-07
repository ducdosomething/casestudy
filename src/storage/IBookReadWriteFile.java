package storage;

import model.Book;

import java.util.List;

public interface IBookReadWriteFile {
    void writeBooksToFile(List<Book> books, String fileName);

    List<Book> readBooksFromFile(String fileName);
}
