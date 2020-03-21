package xiaoming.zixue.springcloud_eureka_provider_8080.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Administrator
 * @Date 2020/3/19
 * @Version 1.0
 */
@RestController
public class ProviderController {

    @Value("${server.port}")
    private int port;

    @RequestMapping("/hello")
    public String hello(){
        return "调用了微服务，端口号为：" + port;
    }

}
