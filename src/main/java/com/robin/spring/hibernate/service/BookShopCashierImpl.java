package com.robin.spring.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("bookShopCashier")
public class BookShopCashierImpl implements BookShopCashier {

    @Autowired
    private BookShopService bookShopService;

    @Transactional
    public void checkout(String username, List<String> isbns) {
        for (String isbn : isbns) {
            bookShopService.purchase(username,isbn);
        }
    }
}
