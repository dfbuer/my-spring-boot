package com.buer.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.buer.domain.Book;

public interface IBookService extends IService<Book> {

    //IPage<Book> getPage(Integer currentPage, Integer pageSize);

    IPage<Book> getPage1(Integer currentPage, Integer pageSize, Book book);
}
