package com.fengin.springcloud.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * @author feng
 * @date 2022/1/18
 */
@Configuration
public class ConfigBean {
    // 【IRule 接口】
    // 负载均衡的实现类：
    // RoundRobinRule：轮询
    // RandomRule：随机访问
    // AvailabilityFilteringRule：先过滤掉访问故障的服务，然后轮询
    // RetryRule：先轮训，若获取失败，则在指定时间内重试，默认10次


    @LoadBalanced   // 配置负载均衡实现,Ribbon
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


}
