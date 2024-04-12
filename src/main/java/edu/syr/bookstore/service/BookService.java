package edu.syr.bookstore.service;


import edu.syr.bookstore.enums.BookStatus;
import edu.syr.bookstore.interfaces.BookServiceInterface;
import edu.syr.bookstore.model.Book;
import edu.syr.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookService implements BookServiceInterface {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public BookStatus buyBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        if (!book.isBought()) {
            book.setBought(true);  // Mark the book as bought
            bookRepository.save(book);
            return BookStatus.SUCCESS;
        }
        return BookStatus.FAIL;  // Book is already bought
    }

    public BookStatus sellBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        if (book.isBought()) {
            book.setBought(false);  // Mark the book as not bought
            // Depreciate the price by 10% before selling
            book.setPrice(book.getPrice().multiply(new BigDecimal("0.9")));
            bookRepository.save(book);
            return BookStatus.SUCCESS;
        }
        return BookStatus.FAIL;  // Book cannot be sold because it wasn't bought
    }

    public BookStatus sellBookByISBN(String ISBN) {
        Book book = bookRepository.findByISBN(ISBN).orElseThrow();
        if (book.isBought()) {
            book.setBought(false);  // Mark the book as not bought
            // Depreciate the price by 10% before selling
            book.setPrice(book.getPrice().multiply(new BigDecimal("0.9")));
            bookRepository.save(book);
            return BookStatus.SUCCESS;
        }
        return BookStatus.FAIL;  // Book cannot be sold because it wasn't bought
    }

    public List<Book> getOwnedBooks() {
        return bookRepository.findByIsBought(true);
    }


}
