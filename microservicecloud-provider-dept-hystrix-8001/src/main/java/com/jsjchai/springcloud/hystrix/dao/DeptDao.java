package com.jsjchai.springcloud.hystrix.dao;


import com.jsjchai.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author jsjchai
 */
@Mapper
public interface DeptDao
{
	boolean addDept(Dept dept);

	Dept findById(Long id);

	List<Dept> findAll();
}
