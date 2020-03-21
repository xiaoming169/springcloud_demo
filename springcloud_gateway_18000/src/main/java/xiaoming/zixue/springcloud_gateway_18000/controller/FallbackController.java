package xiaoming.zixue.springcloud_gateway_18000.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Administrator
 * @Date 2020/3/20
 * @Version 1.0
 */
@RestController
public class FallbackController {

    @RequestMapping("/fallback")
    public String fallback(){
        return "服务器繁忙，请稍后重试,路由网关";
    }

}
