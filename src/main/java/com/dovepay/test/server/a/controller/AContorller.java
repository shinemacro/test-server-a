 package com.dovepay.test.server.a.controller;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
@RequestMapping(value="/")
@Api(value = "a", description = "a管理", produces = MediaType.APPLICATION_JSON_VALUE)
public class AContorller {
    
    @Autowired
    AService aService;
    
    @Autowired
    private Environment env; 
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    @ApiOperation(value="test-server-a服务启动接口", notes="返回服务信息")
    public Object index(){
        System.out.println("test-server-a run...");
        Map<String, Object> result = new LinkedHashMap<String, Object>();
        result.put("serverVersion", "v1");
        result.put("serverName", "test-server-a");
        result.put("spring.profiles.active", env.getProperty("spring.profiles.active"));
        result.put("env", env.getProperty("a.env"));
        result.put("burl", env.getProperty("a.burl"));
        try {
            result.put("localName", InetAddress.getLocalHost().getHostName());
            result.put("localIp", InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
             e.printStackTrace();
        }
        result.put("ipList", getLocalIPList());
        
        // Get JVM's thread system bean
        RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
        // Get start time
        long startTime = bean.getStartTime();
        // Get start Date
        Date startDate = new Date(startTime);
        result.put("jvmStartTime", new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(startDate));

        return result;
    }
    
    @RequestMapping(value="/a", method=RequestMethod.GET)
    @ApiOperation(value="查询所有a接口", notes="返回所有a")
    public String getAllA(){
        System.out.println("getAllA run...");
        return "all a Hello World!";
    }
    
    @ApiOperation(value="a查询接口", notes="根据ID返回a")
    @RequestMapping(value="/a/{id}", method=RequestMethod.GET)
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
    
    public static List<String> getLocalIPList() {
        List<String> ipList = new ArrayList<String>();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            NetworkInterface networkInterface;
            Enumeration<InetAddress> inetAddresses;
            InetAddress inetAddress;
            String ip;
            while (networkInterfaces.hasMoreElements()) {
                networkInterface = networkInterfaces.nextElement();
                inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    inetAddress = inetAddresses.nextElement();
                    //if (inetAddress != null && inetAddress instanceof Inet4Address) { // IPV4
                    if (inetAddress != null) {
                        ip = inetAddress.getHostAddress();
                        ipList.add(ip);
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return ipList;
    }
}
