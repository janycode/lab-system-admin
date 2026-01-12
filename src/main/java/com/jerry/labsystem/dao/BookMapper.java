package com.jerry.labsystem.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper<Book> {
    List<Book> getBookList(Book book);
    void updateBookList(Book book);
    void deleteBookList(Integer id);
    void addBookList(Book book);
}
