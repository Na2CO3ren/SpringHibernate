package com.robin.spring.hibernate.service;

import java.util.List;

public interface BookShopCashier {
    void checkout(String username, List<String> isbns);
}
