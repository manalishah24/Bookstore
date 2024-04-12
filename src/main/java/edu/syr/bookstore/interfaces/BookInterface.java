package edu.syr.bookstore.interfaces;

import java.math.BigDecimal;

public interface BookInterface {
    Long getId();
    void setId(Long id);

    String getISBN();
    void setISBN(String ISBN);

    String getAuthor();
    void setAuthor(String author);

    String getTitle();
    void setTitle(String title);

    String getEdition();
    void setEdition(String edition);

    BigDecimal getPrice();
    void setPrice(BigDecimal price);

    boolean isBought();
    void setBought(boolean isBought);
}
