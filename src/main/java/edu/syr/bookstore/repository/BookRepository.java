package edu.syr.bookstore.repository;


import edu.syr.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByISBN(String ISBN);
    List<Book> findByIsBought(boolean isBought);
}
