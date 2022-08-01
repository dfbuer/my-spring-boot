package com.buer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buer.dao.BookDao;
import com.buer.domain.Book;
import com.buer.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IBookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

    @Autowired
    private BookDao bookDao;

    //@Override
    //public IPage<Book> getPage(Integer currentPage, Integer pageSize) {
    //    IPage<Book> iPage = new Page<>(currentPage,pageSize);
    //    bookDao.selectPage(iPage,null);
    //    return iPage;
    //}

    @Override
    public IPage<Book> getPage1(Integer currentPage, Integer pageSize, Book book) {
        IPage<Book> iPage = new Page<>(currentPage,pageSize);
        System.out.println("1");
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        return bookDao.selectPage(iPage,lambdaQueryWrapper);
    }
}
