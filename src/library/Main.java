package library;

import library.model.Book;
import library.servise.BookService;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerString = new Scanner(System.in);

    public static void main(String[] args) {
        BookService bookService = new BookService();
        boolean mainLoop = true;
        while (mainLoop) {
            System.out.println("""
                    1. Add Book
                    2. Get All Books
                    3. Get Book
                    4. Delete Book
                    0. Exit
                    """);
            switch (scannerInt.nextInt()) {
                case 1 -> {
                    System.out.print("Enter Book Title: ");
                    String title = scannerString.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scannerString.nextLine();
                    Book book = new Book();
                    book.setTitle(title);
                    book.setAuthor(author);
                    boolean result = bookService.addBook(book);
                    if (result) {
                        System.out.println("Book added successfully!");
                    } else {
                        System.out.println("Book could not be added!");
                    }
                }
                case 2 -> {
                    List<Book> books = bookService.getBooks();
                    for (Book book : books) {
                        System.out.println(book);
                    }
                }
                case 3 -> {
                    boolean caseLoop = true;
                    while (caseLoop) {
                        System.out.println("""
                                1. Get Book By ID
                                2. Get Book By Title
                                0. Exit
                                """);
                        switch (scannerInt.nextInt()) {
                            case 1 -> {
                                System.out.print("Enter Book ID: ");
                                UUID id = UUID.fromString(scannerString.nextLine());
                                Book book = bookService.getBook(id);
                                if (book != null) {
                                    System.out.println(book);
                                } else {
                                    System.out.println("Book could not be found!");
                                }
                            }
                            case 2 -> {
                                System.out.print("Enter Book Title: ");
                                String title = scannerString.nextLine();
                                Book book = bookService.getBook(title);
                                if (book != null) {
                                    System.out.println(book);
                                } else {
                                    System.out.println("Book could not be found!");
                                }
                            }
                            case 0 -> caseLoop = false;
                        }
                    }
                }

                case 4 -> {
                    boolean caseLoop = true;
                    while (caseLoop) {
                        System.out.println("""
                                1. Delete Book By ID
                                2. Delete Book By Title
                                0. Exit
                                """);
                        switch (scannerInt.nextInt()) {
                            case 1 -> {
                                System.out.println("Enter Book ID: ");
                                UUID id = UUID.fromString(scannerString.nextLine());
                                boolean result = bookService.deleteBook(id);
                                if (result) {
                                    System.out.println("Book deleted successfully!");
                                } else {
                                    System.out.println("Book could not be deleted!");
                                }
                            }
                            case 2 -> {
                                System.out.print("Enter Book Title: ");
                                String title = scannerString.nextLine();
                                boolean result = bookService.deleteBook(title);
                                if (result) {
                                    System.out.println("Book deleted successfully!");
                                } else {
                                    System.out.println("Book could not be deleted!");
                                }
                            }
                            case 0 -> caseLoop = false;
                        }
                    }
                }

                case 0 -> mainLoop = false;
            }
        }

    }
}
