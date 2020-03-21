package xiaoming.zixue.springcloud_eureka_consumer_9001.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import xiaoming.zixue.springcloud_eureka_consumer_9001.feign.impl.MyFeignImpl;

/**
 * @Author Administrator
 * @Date 2020/3/19
 * @Version 1.0
 */
@FeignClient(value = "provider",fallback = MyFeignImpl.class)
public interface MyFeign {

    @RequestMapping("/hello")
    String hello();

}
