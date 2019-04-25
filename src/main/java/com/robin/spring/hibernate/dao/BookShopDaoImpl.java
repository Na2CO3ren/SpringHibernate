package com.robin.spring.hibernate.dao;

import com.robin.spring.hibernate.entities.Account;
import com.robin.spring.hibernate.exception.AccountException;
import com.robin.spring.hibernate.exception.BookShopException;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private SessionFactory sessionFactory;


    public Double findPriceForBook(String isbn) {
        String sql = "SELECT price FROM Book WHERE isbn = ?0";
        Query query = sessionFactory.getCurrentSession().createQuery(sql).setParameter(0,isbn);
        return (Double) query.getSingleResult();
    }

    public void updateAccount(String username, Double price) {
        String sql = "SELECT balance FROM Account WHERE name LIKE(?0)";
        Query query = sessionFactory.getCurrentSession().createQuery(sql).setParameter(0,username);
        Double balance = (Double)query.getSingleResult();

        if (balance < price) {
            throw (new AccountException("余额不足"));
        }

        sql = "UPDATE Account SET balance = balance - ?0 WHERE name = ?1";
        sessionFactory.getCurrentSession().createQuery(sql).setParameter(0,price).setParameter(1,username).executeUpdate();
    }

    public void updateBookStock(String isbn) {
        String sql = "SELECT stock FROM Book WHERE isbn LIKE(?0)";
        Query query = sessionFactory.getCurrentSession().createQuery(sql).setParameter(0,isbn);
        Integer stock = (Integer)query.getSingleResult();

        if (stock <= 0) {
            throw (new BookShopException("库存不足"));
        }

        sql = "UPDATE Book SET stock = stock - 1 WHERE isbn = ?0";
        sessionFactory.getCurrentSession().createQuery(sql).setParameter(0,isbn).executeUpdate();
    }
}
