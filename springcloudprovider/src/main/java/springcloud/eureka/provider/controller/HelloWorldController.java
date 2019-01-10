package springcloud.eureka.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springcloud.eureka.provider.service.HelloWorld;

@RestController
public class HelloWorldController {

    @Autowired
    HelloWorld helloWorld;
    @RequestMapping(value = "/provider")
    String hello(@RequestParam String name){
        return helloWorld.hello(name);
    }
}
