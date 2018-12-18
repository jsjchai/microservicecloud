package com.jsjchai.springcloud.consumer;

import com.jsjchai.springcloud.entity.Dept;
import com.jsjchai.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/consumer/dept/")
public class DeptController {

	@Autowired
	private DeptClientService deptClientService;

	@PostMapping(value = "add")
	public boolean add(Dept dept)
	{
		return deptClientService.add(dept);
	}

	@GetMapping(value = "get/{id}")
	public Dept get(@PathVariable("id") Long id)
	{
		return deptClientService.get(id);
	}


	@GetMapping(value = "list")
	public List<Dept> list() {

		return deptClientService.list();
	}

}
