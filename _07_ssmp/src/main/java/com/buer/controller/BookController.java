package com.buer.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.buer.domain.Book;
import com.buer.service.IBookService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/xxx")
public class BookController {

    @Autowired
    private IBookService iBookService;

    @GetMapping
    public List<Book> getAll(){
        return  iBookService.list();
    }

    @PostMapping
    public Boolean save(@RequestBody Book book){
        return iBookService.save(book);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book){
        return iBookService.updateById(book);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id){
        return iBookService.removeById(id);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable("id") Integer id){
        return iBookService.getById(id);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public IPage<Book> getByPage(@PathVariable("currentPage") Integer currentPage,@PathVariable("pageSize") Integer pageSize){
        return iBookService.getPage1(currentPage,pageSize,null);
    }

}
