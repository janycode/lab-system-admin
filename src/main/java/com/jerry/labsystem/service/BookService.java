package com.jerry.labsystem.service;

import java.util.List;

public interface BookService<Book> {
    List<Book> getBookList(Book book);
    void updateBookList(Book book);
    void deleteBookList(Integer id);
    void addBookList(Book book);
}
