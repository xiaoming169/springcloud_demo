package xiaoming.zixue.springcloud_eureka_consumer_9000.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Administrator
 * @Date 2020/3/19
 * @Version 1.0
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private int port;

    @HystrixCommand(fallbackMethod = "MyFallback")
    @RequestMapping("/hello2")
    public String hello2(){
        String result = restTemplate.getForObject("http://provider/hello", String.class);
        return "调用了服务消费者，端口号为：" + port +",调用了服务提供者," + result;
    }

    /**
     * 降级方法
     * @return
     */
    public String MyFallback(){
        return "系统繁忙，请稍后重试";
    }

}
