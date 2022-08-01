package com.buer.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.buer.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class IBookServiceTestCase {
    @Autowired
    private IBookService iBookService;

    @Test
    void testGetById(){
        Book book = iBookService.getById(1);
        System.out.println(book);
    }

    @Test
    void save() {
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        iBookService.save(book);
        System.out.println("添加成功");
    }

    @Test
    void update() {
        Book book = new Book();
        book.setId(1);
        book.setType("测试数据777");
        book.setName("测试数据666");
        book.setDescription("测试数据666");
        iBookService.updateById(book);
        System.out.println("修改成功");
    }

    @Test
    void delete() {
        iBookService.removeById(36);
        System.out.println("删除成功");

    }

    @Test
    void getAll() {
        List<Book> list = iBookService.list();
        list.forEach(System.out::println);
    }

    @Test
    void getByPage() {
        IPage<Book> iPage = new Page<>(1,5);
        iBookService.page(iPage);
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
