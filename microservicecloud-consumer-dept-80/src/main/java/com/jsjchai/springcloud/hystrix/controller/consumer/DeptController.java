package com.jsjchai.springcloud.hystrix.controller.consumer;

import com.jsjchai.springcloud.entity.Dept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;



@RestController
@RequestMapping("/consumer/dept/")
public class DeptController {

	@Value("${rest.url.prefix}")
	private  String REST_URL_PREFIX ;


	/**
	 * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
	 * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
	 */
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping(value = "add")
	public boolean add(Dept dept)
	{
		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
	}

	@GetMapping(value = "get/{id}")
	public Dept get(@PathVariable("id") Long id)
	{
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
	}


	@GetMapping(value = "list")
	public List<Dept> list() {

		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
	}


	@GetMapping(value = "discovery")
	public Object discovery() {

		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
	}




}
