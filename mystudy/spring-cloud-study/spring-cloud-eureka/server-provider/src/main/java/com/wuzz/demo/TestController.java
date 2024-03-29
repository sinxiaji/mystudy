package com.wuzz.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create with IntelliJ IDEA
 * User: Wuzhenzhao
 * Date: 2019/4/10
 * Time: 14:43
 * Description 描述:
 */
@RestController
public class TestController {

    @Autowired//服务发现
    private DiscoveryClient client;

    @GetMapping("/hello")
    public String helloEureka(){
         return  "Hello Eureka Provider";
    }

    /**
     * 服务发现
     * @return
     */
    @RequestMapping(value ="/discovery",method= RequestMethod.GET)
    public Object discovery() {
        List<String> list = client.getServices();
        List<ServiceInstance> instances = client.getInstances("");
        for(ServiceInstance instance  : instances) {
            System.out.println(instance.getHost());
        }
        return this.client;
    }
}
