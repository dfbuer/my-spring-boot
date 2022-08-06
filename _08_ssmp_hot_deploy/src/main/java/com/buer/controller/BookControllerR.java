package com.buer.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.buer.controller.utils.R;
import com.buer.domain.Book;
import com.buer.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/books")
public class BookControllerR{

    @Autowired
    private IBookService iBookService;

    @GetMapping
    public R getAll(){
        return  new R(true,iBookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book){
        boolean flag = iBookService.save(book);
        return new R(flag, flag ? "添加成功^_^!": "添加失败-_-!");
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(iBookService.updateById(book));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable("id") Integer id){
        System.out.println("deploy...");
        System.out.println("deploy...");
        System.out.println("deploy...");
        System.out.println("deploy...");
        return new R(iBookService.removeById(id));
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable("id") Integer id){
        return new R(true,iBookService.getById(id));
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getByPage(@PathVariable("currentPage") Integer currentPage,@PathVariable("pageSize") Integer pageSize, Book book){
        IPage<Book> page = iBookService.getPage1(currentPage, pageSize,book);
        //如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        //System.out.println(book);
        if (currentPage > page.getPages()){
            page = iBookService.getPage1(currentPage, pageSize,book);
        }
        return new R(true,page);
    }

}
