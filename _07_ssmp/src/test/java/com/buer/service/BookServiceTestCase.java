package com.buer.service;

import com.buer.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTestCase {
    @Autowired
    private BookService bookService;

    @Test
    void testGetById(){
        Book book = bookService.getById(1);
        System.out.println(book);
    }

    @Test
    void save() {
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookService.save(book);
        System.out.println("添加成功");
    }

    @Test
    void update() {
        Book book = new Book();
        book.setId(34);
        book.setType("测试数据777");
        book.setName("测试数据666");
        book.setDescription("测试数据666");
        bookService.update(book);
        System.out.println("修改成功");
    }

    @Test
    void delete() {
        bookService.delete(34);
        System.out.println("删除成功");

    }

    @Test
    void getAll() {
        List<Book> list = bookService.getAll();
        list.forEach(System.out::println);
    }

    @Test
    void getByPage() {
        bookService.getPage(2,5);
    }

//    @Test
//    void getByCondition1() {
//        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("name","spring");
//        bookDao.selectList(queryWrapper);
//    }

//    @Test
//    void getByCondition2() {
//        String name = null;
//        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper();
//        lambdaQueryWrapper.like(name!=null,Book::getName,name);
//        bookDao.selectList(lambdaQueryWrapper);
//    }

}
