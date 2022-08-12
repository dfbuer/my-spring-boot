package com.buer.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.buer.domain.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonDao extends BaseMapper<Person> {
}
