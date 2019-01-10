package springcloud.eureka.client.service.impl;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springcloud.eureka.client.service.impl.HelloRemoteHystrix;
@Primary
@FeignClient(name = "spring-cloud-provider",fallback =HelloRemoteHystrix.class )
public interface HelloRemote {

    @RequestMapping(value = "/provider")
     String hello(@RequestParam(value = "name") String name);
}

