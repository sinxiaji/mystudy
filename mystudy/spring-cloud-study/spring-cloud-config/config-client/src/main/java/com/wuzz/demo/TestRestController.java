package com.wuzz.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create with IntelliJ IDEA
 * User: Wuzhenzhao
 * Date: 2019/4/4
 * Time: 12:25
 * Description 描述:
 */
@RestController
public class TestRestController {

    @Value("${foo}")
    String foo;

    @RequestMapping(value = "/hello")
    public String hello(){
        return foo;
    }
}
