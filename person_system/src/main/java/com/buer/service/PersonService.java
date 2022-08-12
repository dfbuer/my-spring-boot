package com.buer.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.buer.domain.Person;

public interface PersonService extends IService<Person> {

    IPage<Person> getByPage(Integer currentPage,Integer pageSize,Person person);
}
