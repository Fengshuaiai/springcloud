package com.fengin.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author feng
 * @date 2022/1/18
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)      //链式写法
public class Dept {
    private Long deptno;
    private String dname;
    private String db_source;//这个数据是存在哪个数据库的字段
    //微服务架构：一个服务对应一个数据库，也就是说同一个信息会存到不同的数据库，因此需要 db_source 进行区分


    /**
     * 链式写法：
     * Dept dept=new Dept();
     * dept.setDeptNo(11).setDname('ssss').setDb_source('001')
     */
}
