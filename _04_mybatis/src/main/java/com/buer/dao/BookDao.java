package com.buer.dao;

import com.buer.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao {
    @Select("select * from t_emp where emp_id = #{id}")
    public Book getById(Integer id);
}
