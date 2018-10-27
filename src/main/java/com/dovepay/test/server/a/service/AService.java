 package com.dovepay.test.server.a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dovepay.test.server.a.bean.B;

/**
 * @author zhaoyh
 * @date 2018/10/27
 */
@Service
public class AService {

    @Autowired
    private Environment env; 
    
    @Autowired
    private RestTemplate restTemplate;
    
    public B getB(int id) {
        String url = env.getProperty("a.burl");
        System.out.println("restTemplate start...");
        B b = null;
        try {
            url = url+"/b/"+id;
            System.out.println("restTemplate burl:"+url);
            b = restTemplate.getForObject(url, B.class);
        }catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("restTemplate result:" + b);
        System.out.println("restTemplate end...");
        return b;
    }
}
