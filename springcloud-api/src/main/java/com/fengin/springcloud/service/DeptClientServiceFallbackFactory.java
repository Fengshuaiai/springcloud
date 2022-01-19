package com.fengin.springcloud.service;

import com.fengin.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author feng
 * @date 2022/1/18
 */
//服务降级
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept queryById(Long id) {
                return new Dept().setDeptno(id)
                        .setDname("id => " + id + "没有对应的信息，该服务已经被关闭")
                        .setDb_source("null");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }
        };
    }
}
