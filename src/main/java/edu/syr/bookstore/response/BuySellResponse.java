package edu.syr.bookstore.response;

import edu.syr.bookstore.enums.BookStatus;
import edu.syr.bookstore.interfaces.BuySellResponseInterface;

import java.math.BigDecimal;

public class BuySellResponse implements BuySellResponseInterface {
    private BookStatus status;
    private BigDecimal price;

    public BuySellResponse(BookStatus status, BigDecimal price) {
        this.status = status;
        this.price = price;
    }

    public BookStatus getStatus() {
        return status;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
