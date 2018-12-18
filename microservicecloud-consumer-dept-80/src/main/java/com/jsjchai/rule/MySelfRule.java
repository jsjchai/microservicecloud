package com.jsjchai.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class MySelfRule {

    /**
     * 定义负载均衡为随机
     * @return
     */
    @Bean
    public IRule selfRule(){
        return new RandomRule();
    }
}
