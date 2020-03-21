package xiaoming.zixue.springcloud_eureka_consumer_9001.feign.impl;

import org.springframework.stereotype.Component;
import xiaoming.zixue.springcloud_eureka_consumer_9001.feign.MyFeign;

/**
 * @Author Administrator
 * @Date 2020/3/20
 * @Version 1.0
 */
@Component
public class MyFeignImpl implements MyFeign {
    @Override
    public String hello() {
        return "系统繁忙，请稍后重试";
    }
}
