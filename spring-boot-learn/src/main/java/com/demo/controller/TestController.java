package com.demo.controller;

import com.demo.config.AppProp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    AppProp appProp;

    //测试开发环境与生产环境下application.properties中的值
    @GetMapping("/get/application/a")
    public String getA() {
        return appProp.getA();
    }

    @GetMapping("/main/cookie")
    public String getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Map<String, String> r = new HashMap<String, String>();
        if (cookies != null){
            for (Cookie cookie: cookies){
                r.put(cookie.getName(), cookie.getValue());
            }
        }
        System.out.println(r.get("token"));
        return r.get("token");
    }

    @GetMapping("/helloworld")
    public String helloworld() {
        return "helloworld";
    }

    @GetMapping("/helloworld2")
    public String helloworld2() {
        return "helloworld2";
    }
    @GetMapping("/helloworld3")
    public String helloworld3() {
        return "helloworld3";
    }


}