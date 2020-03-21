package xiaoming.zixue.springcloud_eureka_consumer_9001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xiaoming.zixue.springcloud_eureka_consumer_9001.feign.MyFeign;

/**
 * @Author Administrator
 * @Date 2020/3/19
 * @Version 1.0
 */
@RestController
@RefreshScope
public class ConsumerController {

    @Value("${com.name}")
    private String name;

    @Autowired
    private MyFeign myFeign;

    @Value("${server.port}")
    private int port;

    @RequestMapping("/hello2")
    public String hello2(){
        String result = myFeign.hello();
        System.out.println("当前线程为：" + Thread.currentThread().getName());
        return "调用了服务消费者，端口号为：" + port +",调用了服务提供者," + result + name;
    }
}
