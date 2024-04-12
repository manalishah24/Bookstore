package edu.syr.bookstore.interfaces;


import edu.syr.bookstore.enums.BookStatus;
import edu.syr.bookstore.model.Book;

import java.util.List;

public interface BookServiceInterface {
    List<Book> getAllBooks();
    BookStatus buyBookById(Long id);
    BookStatus sellBookById(Long id);
    BookStatus sellBookByISBN(String ISBN);

    List<Book> getOwnedBooks();
}
