package com.fengin.springcloud;

import com.fengin.myrule.config.ChaoRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author feng
 * @date 2022/1/18
 */
// Ribbon  和 Eureka 整合后，客户端可以直接调用，不用关心 ip 地址
@SpringBootApplication
@EnableEurekaClient
//在微服务启动的时候就能去加载自定义的 ribbon 类
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT", configuration = ChaoRule.class)
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class, args);
    }
}

