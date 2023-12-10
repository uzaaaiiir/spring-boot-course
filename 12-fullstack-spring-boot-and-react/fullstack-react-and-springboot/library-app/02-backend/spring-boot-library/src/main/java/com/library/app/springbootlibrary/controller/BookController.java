package com.library.app.springbootlibrary.controller;

import com.library.app.springbootlibrary.entity.Book;
import com.library.app.springbootlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;
    private static final String USER_EMAIL = "testuser@email.com";

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/secure/currentloans/count")
    public int currentLoansCount() {
        return bookService.currentLoansCount(USER_EMAIL);
    }

    @GetMapping("/secure/ischeckedout/byuser")
    public Boolean checkoutBookByUser(@RequestParam Long bookId) {
        return bookService.checkoutBookByUser(USER_EMAIL, bookId);
    }

    @PutMapping("/secure/checkout")
    public Book checkoutBook(@RequestParam Long bookId) throws Exception {
        return bookService.checkoutBook(USER_EMAIL, bookId);
    }
}
