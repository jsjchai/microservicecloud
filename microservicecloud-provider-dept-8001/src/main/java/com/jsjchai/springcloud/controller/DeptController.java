package com.jsjchai.springcloud.controller;

import com.jsjchai.springcloud.entity.Dept;
import com.jsjchai.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController
{
	@Autowired
	private DeptService service;
	@Autowired
	private DiscoveryClient discoveryClient;


	@PostMapping (value = "/add")
	public boolean add(@RequestBody Dept dept)
	{
		return service.add(dept);
	}

	@GetMapping(value = "/get/{id}")
	public Dept get(@PathVariable("id") Long id)
	{
		return service.get(id);
	}

	@GetMapping(value = "/list")
	public List<Dept> list()
	{
		return service.list();
	}


	@GetMapping(value = "/discovery")
	public  Object discovery(){
		List<String> list = discoveryClient.getServices();
		System.out.println("all service:"+list);

		List<ServiceInstance> serviceInstances = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");

		serviceInstances.stream().forEach(e ->{
			System.out.println(e.getHost()+" "+e.getPort()+" "+e.getServiceId());
		});

		return discoveryClient;
	}
}
