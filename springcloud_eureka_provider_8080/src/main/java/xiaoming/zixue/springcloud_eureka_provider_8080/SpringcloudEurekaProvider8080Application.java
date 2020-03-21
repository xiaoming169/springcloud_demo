package xiaoming.zixue.springcloud_eureka_provider_8080;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudEurekaProvider8080Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaProvider8080Application.class, args);
    }

}
