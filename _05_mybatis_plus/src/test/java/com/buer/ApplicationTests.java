package com.buer;

import com.buer.dao.BookDao;
import com.buer.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private BookDao bookDao;


    @Test
    void contextLoads() {
        Book book = bookDao.selectById(1);
        System.out.println(book);
        List<Book> books = bookDao.selectList(null);
        System.out.println(books);
    }

}
