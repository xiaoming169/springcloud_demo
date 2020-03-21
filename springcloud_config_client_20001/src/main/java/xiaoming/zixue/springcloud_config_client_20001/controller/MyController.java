package xiaoming.zixue.springcloud_config_client_20001.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Administrator
 * @Date 2020/3/21
 * @Version 1.0
 */
@RestController
public class MyController {

    @Value("${com.name}")
    private String name;

    @RequestMapping("/test")
    public String test(){
        return name;
    }

}
