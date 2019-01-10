package springcloud.eureka.provider.service.impl;

import org.springframework.stereotype.Service;
import springcloud.eureka.provider.service.HelloWorld;

@Service
public class HelloWorldImpl implements HelloWorld {

    @Override
    public String hello(String name) {

        return "hello world this is from "+ name+ " message";
    }
}
