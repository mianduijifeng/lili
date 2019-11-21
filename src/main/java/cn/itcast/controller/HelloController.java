package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//控制器类
@Controller
public class HelloController {


    @RequestMapping("/hel")
    public String sayHello(){
        System.out.println("Hello faker");
        return "hello";
    }
}
