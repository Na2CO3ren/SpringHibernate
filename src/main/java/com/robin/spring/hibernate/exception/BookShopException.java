package com.robin.spring.hibernate.exception;

public class BookShopException extends RuntimeException {
    public BookShopException() {
    }

    public BookShopException(String message) {
        super(message);
    }

    public BookShopException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookShopException(Throwable cause) {
        super(cause);
    }

    public BookShopException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
