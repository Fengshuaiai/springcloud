package com.fengin.springcloud.controller;

import com.fengin.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author feng
 * @date 2022/1/18
 */
@RestController
public class DeptConsumerController {
    // 消费者不应该有 Service 层，那怎么拿到 Service ?

    // RestTemplate：提供多种便捷访问远程 http 服务的方法，简单的 restful 服务模板
    // 注册到 spring 中
    // RestTemplace 参数：（String url, Class<T> responseType, Object... uriVariables）

    //通过 Ribbon 实现的时候，地址应该是变量，请求这个应用的名字即可
    //private static final String REST_URL_PREFIX="http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @PostMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "dept/add", dept, Boolean.class);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }
}
