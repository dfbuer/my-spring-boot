package com.buer.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.buer.controller.utils.R;
import com.buer.domain.Person;
import com.buer.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public R getAll(){
        return new R(true,personService.list());
    }

    @PostMapping
    public R add(@RequestBody Person person){
        boolean save = personService.save(person);
        return new R(save,save ? "添加成功^_^!": "添加失败-_-!");
    }

    @PutMapping
    public R update(@RequestBody Person person){
        boolean b = personService.updateById(person);
        return new R(b);
    }

    @GetMapping("/{id}")
    public R updateSelectById(@PathVariable Integer id){
        return new R(true,personService.getById(id));
    }

    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable Integer id){
        return new R(personService.removeById(id));
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getByPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize,Person person){
        //System.out.println(currentPage+ ","+pageSize);
        IPage<Person> page = personService.getByPage(currentPage, pageSize, person);
        if (currentPage > page.getPages()){
            page = personService.getByPage((int) page.getPages(), pageSize, person);
        }
        return new R(true,page);
    }
}
