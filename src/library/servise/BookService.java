package library.servise;

import library.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookService {
    private List<Book> books = new ArrayList<>();

    public boolean addBook(Book book) {
        if (book == null) {
            return false;
        }

        books.add(book);
        return true;
    }

    public boolean deleteBook(UUID id) {
        if (id == null) {
            return false;
        }

        books.removeIf(book -> book.getId().equals(id));
        return true;
    }

    public boolean deleteBook(String title) {
        if (title == null) {
            return false;
        }

        books.removeIf(book -> book.getTitle().equals(title));
        return true;
    }

    public Book getBook(UUID id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }

        return null;
    }

    public Book getBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }

        return null;
    }

    public List<Book> getBooks() {
        return books;
    }
}
