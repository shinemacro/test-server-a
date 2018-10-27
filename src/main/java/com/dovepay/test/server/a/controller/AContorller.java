 package com.dovepay.test.server.a.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dovepay.test.server.a.bean.A;
import com.dovepay.test.server.a.service.AService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author zhaoyh
 * @date 2018/10/27
 */
@RestController
@RequestMapping(value="/a")
@Api(value = "a", description = "a管理", produces = MediaType.APPLICATION_JSON_VALUE)
public class AContorller {
    
    @Autowired
    AService aService;
    
    @Autowired
    private Environment env; 
    
    @RequestMapping(method=RequestMethod.GET)
    @ApiOperation(value="查询所有a接口", notes="返回所有a")
    public String index(){
        System.out.println("getAllA run...");
        return "all a Hello World!";
    }
    
    @ApiOperation(value="a查询接口", notes="根据ID返回a")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Object getA(@PathVariable(value = "id") Integer id){
        A a = new A();
        a.setId(id);
        a.setCreateTime(new Date());
        a.setDescription("server a");
        a.setVersion("0.0.1");
        a.setName("testA");
        a.setEnvironment(env.getProperty("a.env"));
        a.setB(aService.getB(id));
        System.out.println("getA:"+a);
        return a;
    }
}
