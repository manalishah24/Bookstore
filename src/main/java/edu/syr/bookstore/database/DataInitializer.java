package edu.syr.bookstore.database;

import edu.syr.bookstore.interfaces.DataInitializerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import edu.syr.bookstore.model.Book;
import edu.syr.bookstore.repository.BookRepository;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DataInitializer implements DataInitializerInterface {

    private final BookRepository bookRepository;

    @Autowired
    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        initializeData();
    }

    public void initializeData() {
        // Create a list of real book data
        List<Book> books = List.of(
                new Book("978-0451524935", "George Orwell", "1984", "2nd", BigDecimal.valueOf(10.62)),
                new Book("978-0061120084", "George Orwell", "Animal Farm", "3rd", BigDecimal.valueOf(9.99)),
                new Book("978-0307454544", "Harper Lee", "To Kill a Mockingbird", "2nd", BigDecimal.valueOf(12.00)),
                new Book("978-1400034770", "Khaled Hosseini", "The Kite Runner", "4th", BigDecimal.valueOf(15.95)),
                new Book("978-0743273565", "Dan Brown", "The Da Vinci Code", "2nd", BigDecimal.valueOf(8.99)),
                new Book("978-0345339681", "J.R.R. Tolkien", "The Fellowship of the Ring", "3rd", BigDecimal.valueOf(14.99)),
                new Book("978-1451673319", "Suzanne Collins", "The Hunger Games", "3rd", BigDecimal.valueOf(11.50)),
                new Book("978-0747546290", "J.K. Rowling", "Harry Potter and the Philosopher's Stone", "2nd", BigDecimal.valueOf(12.95)),
                new Book("978-0452284240", "F. Scott Fitzgerald", "The Great Gatsby", "2nd", BigDecimal.valueOf(9.75)),
                new Book("978-1612680194", "Napoleon Hill", "Think and Grow Rich", "5th", BigDecimal.valueOf(8.75))
        );

        bookRepository.saveAll(books);
    }
}

