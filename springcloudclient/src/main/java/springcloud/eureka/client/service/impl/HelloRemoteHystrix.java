package springcloud.eureka.client.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class HelloRemoteHystrix implements HelloRemote {



    @Override
    public String hello(@RequestParam(value = "name") String name) {
//        return restTemplate.getForObject("http://spring-cloud-provicer/provider?name=" + name, String.class);
        return "hello" +name+", this messge send failed ";
    }
}