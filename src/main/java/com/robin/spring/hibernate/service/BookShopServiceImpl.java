package com.robin.spring.hibernate.service;

import com.robin.spring.hibernate.dao.BookShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
@Transactional
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    BookShopDao bookShopDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void purchase(String username, String isbn) {
        Double price = bookShopDao.findPriceForBook(isbn);
        bookShopDao.updateBookStock(isbn);
        bookShopDao.updateAccount(username,price);
    }
}
