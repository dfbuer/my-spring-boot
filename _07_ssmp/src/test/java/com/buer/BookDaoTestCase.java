package com.buer;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.buer.dao.BookDao;
import com.buer.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void getById() {
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void save() {
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.insert(book);
        System.out.println("添加成功");
    }

    @Test
    void update() {
        Book book = new Book();
        book.setId(34);
        book.setType("测试数据666");
        book.setName("测试数据666");
        book.setDescription("测试数据666");
        bookDao.updateById(book);
        System.out.println("修改成功");
    }

    @Test
    void delete() {
        bookDao.deleteById(35);
        System.out.println("删除成功");

    }

    @Test
    void getAll() {
        List<Book> list = bookDao.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    void getByPage() {
        IPage iPage = new Page(2,5);
        bookDao.selectPage(iPage,null);
//        iPage.xxx可以获取各种参数
        List records = iPage.getRecords();
        System.out.println(records);
    }

    @Test
    void getByCondition1() {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","spring");
        bookDao.selectList(queryWrapper);
    }

    @Test
    void getByCondition2() {
        String name = null;
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(name!=null,Book::getName,name);
        bookDao.selectList(lambdaQueryWrapper);
    }

}
