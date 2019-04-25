package com.robin.spring.hibernate.dao;

public interface BookShopDao {
    Double findPriceForBook(String isbn);

    void updateAccount(String username, Double price);

    void updateBookStock(String isbn);
}
