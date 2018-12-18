package com.jsjchai.springcloud.service.impl;

import java.util.List;

import com.jsjchai.springcloud.dao.DeptDao;
import com.jsjchai.springcloud.entity.Dept;
import com.jsjchai.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao dao;
	
	@Override
	public boolean add(Dept dept)
	{
		return dao.addDept(dept);
	}

	@Override
	public Dept get(Long id)
	{
		return dao.findById(id);
	}

	@Override
	public List<Dept> list()
	{
		return dao.findAll();
	}

}
