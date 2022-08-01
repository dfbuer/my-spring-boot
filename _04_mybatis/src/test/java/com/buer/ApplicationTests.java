package com.buer;

import com.buer.dao.BookDao;
import com.buer.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        Book b = bookDao.getById(1);
        System.out.println(b);
    }

}
