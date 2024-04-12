package edu.syr.bookstore.interfaces;

import edu.syr.bookstore.enums.BookStatus;

import java.math.BigDecimal;

public interface BuySellResponseInterface {
    BookStatus getStatus();
    BigDecimal getPrice();
}

