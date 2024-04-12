package edu.syr.bookstore.enums;

import edu.syr.bookstore.interfaces.BookStatusInterface;

import java.math.BigDecimal;

public enum BookStatus implements BookStatusInterface {
    SUCCESS(BigDecimal.valueOf(0)), // Initialize with a default price
    FAIL(BigDecimal.valueOf(0));

    private final BigDecimal price;

    BookStatus(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
