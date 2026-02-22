package com.jerry.labsystem.service.impl;

import com.jerry.labsystem.dao.BookMapper;
import com.jerry.labsystem.pojo.Book;
import com.jerry.labsystem.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 图书服务 impl
 *
 * @author Jerry(姜源)
 * @since 2026/02/22
 */
@Service
public class BookServiceImpl implements BookService<Book> {
    @Resource
    private BookMapper<Book> bookMapper;

    @Override
    public List<Book> getBookList(Book book) {
        return bookMapper.getBookList(book);
    }

    @Override
    public void updateBookList(Book book) {
        bookMapper.updateBookList(book);
    }

    @Override
    public void deleteBookList(Integer id) {
        bookMapper.deleteBookList(id);
    }

    @Override
    public void addBookList(Book book) {
        bookMapper.addBookList(book);
    }
}
