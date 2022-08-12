package com.buer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buer.dao.PersonDao;
import com.buer.domain.Person;
import com.buer.service.PersonService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
public class PersonServiceImpl extends ServiceImpl<PersonDao, Person> implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public IPage<Person> getByPage(Integer currentPage, Integer pageSize, Person person) {
        IPage<Person> iPage = new Page<>(currentPage,pageSize);
        LambdaQueryWrapper<Person> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Strings.isNotEmpty(person.getName()),Person::getName,person.getName());
        //lambdaQueryWrapper.like(Strings.isNotEmpty(person.getSex()),Person::getSex,person.getSex());
        //lambdaQueryWrapper.like(Strings.isNotEmpty(person.getStudentId()),Person::getStudentId,person.getStudentId());
        //lambdaQueryWrapper.like(Strings.isNotEmpty(person.getTele()),Person::getTele,person.getTele());
        lambdaQueryWrapper.like(Strings.isNotEmpty(person.getSpecialized()),Person::getSpecialized,person.getSpecialized());
        //lambdaQueryWrapper.like(Strings.isNotEmpty(person.getSchedule()),Person::getSchedule,person.getSchedule());
        return personDao.selectPage(iPage,lambdaQueryWrapper);
    }
}
