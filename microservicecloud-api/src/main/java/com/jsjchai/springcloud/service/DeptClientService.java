package com.jsjchai.springcloud.service;

import com.jsjchai.springcloud.entity.Dept;
import com.jsjchai.springcloud.service.fallback.DeptClientServiceFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;



//@FeignClient(value = "MICROSERVICECLOUD-DEPT")
@RequestMapping(value = "/dept")
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptClientService
{
	@GetMapping(value = "/get/{id}")
	Dept get(@PathVariable("id") long id);

	@GetMapping(value = "/list")
	List<Dept> list();

	@PostMapping(value = "/add")
	boolean add(Dept dept);
}
