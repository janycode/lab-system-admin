package com.jerry.labsystem.controller;

import com.jerry.labsystem.pojo.Book;
import com.jerry.labsystem.service.BookService;
import com.jerry.labsystem.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/books")
public class BookController {

    @Autowired
    private BookService<Book> labService;

    @GetMapping("/list")
    public List<Book> getBookList(Book book) {
        return labService.getBookList(book);
    }

    @PostMapping("/add")
    public ResultObj addBookList(@RequestBody Book book) {
        try {
            labService.addBookList(book);
            return ResultObj.ADD_SUCCESS;
        } catch (RuntimeException e) {
            return ResultObj.ADD_ERROR;
        }
    }

    @PostMapping("/select")
    public List<Book> selectBookList(@RequestBody Book book) {
        return labService.getBookList(book);
    }

    // /admin/rols/3
    @PutMapping(value = "/{id}")
    public ResultObj updateBookList(@PathVariable Integer id, @RequestBody Book book) {
        try {
            book.setId(id);
            labService.updateBookList(book);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            return ResultObj.UPDATE_ERROR;
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResultObj deleteBookList(@PathVariable Integer id) {
        try {
            labService.deleteBookList(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            return ResultObj.DELETE_ERROR;
        }
    }

}
