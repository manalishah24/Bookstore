package edu.syr.bookstore.interfaces;


import edu.syr.bookstore.response.BuySellResponse;
import edu.syr.bookstore.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BookControllerInterface {
    List<Book> getAllBooks();

    BuySellResponse buyBookById(Long id);

    BuySellResponse sellBookById(Long id);

    BuySellResponse sellBookByISBN(String ISBN);

    List<Book> getOwnedBooks();
}
