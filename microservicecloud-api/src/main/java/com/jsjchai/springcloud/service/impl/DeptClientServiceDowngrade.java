package com.jsjchai.springcloud.service.impl;

import com.jsjchai.springcloud.entity.Dept;
import com.jsjchai.springcloud.service.DeptClientService;

import java.util.Collections;
import java.util.List;


public class DeptClientServiceDowngrade implements DeptClientService {
    @Override
    public Dept get(long id) {
        return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }

    @Override
    public List<Dept> list() {
        return Collections.emptyList();
    }

    @Override
    public boolean add(Dept dept) {
        return false;
    }
}
