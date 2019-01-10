package springcloud.eureka.client.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springcloud.eureka.client.service.impl.HelloRemote;

@RestController
@RequestMapping(value = "/test")
public class ControllerTest {

    @Autowired
    HelloRemote helloRemote;

    @RequestMapping(value = "/hello")
    public String index(@RequestParam String name) {
//        return "hello "+name+"，this is producer 2  send first messge";
//        return  restTemplate.getForObject(a"http://spring-cloud-provicer/provider?name="+name,String.class);
        return helloRemote.hello(name);
    }


}
