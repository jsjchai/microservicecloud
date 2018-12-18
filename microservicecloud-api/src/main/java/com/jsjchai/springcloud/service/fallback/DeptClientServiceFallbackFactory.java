package com.jsjchai.springcloud.service.fallback;

import com.jsjchai.springcloud.service.DeptClientService;
import com.jsjchai.springcloud.service.impl.DeptClientServiceDowngrade;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientServiceDowngrade();
    }
}
