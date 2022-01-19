package com.fengin.myrule.config;


import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 在myRule包下自定义一个配置类MyRule.java，
// 注意：该包不要和主启动类所在的包同级，要跟启动类所在包同级
@Configuration
public class ChaoRule {
    //https://www.springcloud.cc/spring-cloud-greenwich.html#_customizing_the_ribbon_client

    @Bean
    public IRule myRule() {
        return new ChaoRandomRule();
    }
}