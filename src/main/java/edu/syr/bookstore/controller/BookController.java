package edu.syr.bookstore.controller;
import edu.syr.bookstore.interfaces.BookControllerInterface;
import edu.syr.bookstore.repository.BookRepository;


import edu.syr.bookstore.enums.BookStatus;
import edu.syr.bookstore.model.Book;
import edu.syr.bookstore.response.BuySellResponse;
import edu.syr.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController  implements BookControllerInterface {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;


    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/buy/{id}")
    public BuySellResponse buyBookById(@PathVariable Long id) {
        BookStatus status = bookService.buyBookById(id);
        if (status == BookStatus.SUCCESS) {
            // Get the adjusted price and return it with the SUCCESS status
            BigDecimal price = bookRepository.findById(id).orElseThrow().getPrice();
            return new BuySellResponse(status, price);
        }
        return new BuySellResponse(status, BigDecimal.ZERO); // Return a default price if not successful
    }

    @PostMapping("/sell/id/{id}")
    public BuySellResponse sellBookById(@PathVariable Long id) {
        BookStatus status = bookService.sellBookById(id);
        if (status == BookStatus.SUCCESS) {
            // Get the adjusted price and return it with the SUCCESS status
            BigDecimal price = bookRepository.findById(id).orElseThrow().getPrice();
            return new BuySellResponse(status, price);
        }
        return new BuySellResponse(status, BigDecimal.ZERO); // Return a default price if not successful
    }

    @PostMapping("/sell/isbn/{ISBN}")
    public BuySellResponse sellBookByISBN(@PathVariable String ISBN) {
        BookStatus status = bookService.sellBookByISBN(ISBN);
        if (status == BookStatus.SUCCESS) {
            // Get the adjusted price and return it with the SUCCESS status
            BigDecimal price = bookRepository.findByISBN(ISBN).orElse(null).getPrice();
            return new BuySellResponse(status, price);
        }
        return new BuySellResponse(status, BigDecimal.ZERO); // Return a default price if not successful
    }

    @GetMapping("/owned-books")
    public List<Book> getOwnedBooks() {
        return bookService.getOwnedBooks();
    }

}
