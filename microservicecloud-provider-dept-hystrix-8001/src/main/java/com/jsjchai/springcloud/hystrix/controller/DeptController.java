package com.jsjchai.springcloud.hystrix.controller;


import com.jsjchai.springcloud.entity.Dept;
import com.jsjchai.springcloud.hystrix.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController
{
	@Autowired
	private DeptService service;

	@PostMapping(value = "/add")
	public boolean add(@RequestBody Dept dept)
	{
		return service.add(dept);
	}

	@GetMapping(value = "/get/{id}")
	//一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
	@HystrixCommand(fallbackMethod="processHystrix_Get")
	public Dept get(@PathVariable("id") Long id)
	{
		Dept dept = this.service.get(id);

		if (null == dept) {
			throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
		}

		return dept;
	}

	@GetMapping(value = "/list")
	public List<Dept> list()
	{
		return service.list();
	}


	public Dept processHystrix_Get(@PathVariable("id") Long id)
	{
		return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
				.setDb_source("no this database in MySQL");
	}

}
