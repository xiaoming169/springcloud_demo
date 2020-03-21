package xiaoming.zixue.springcloud_config_server_20000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringcloudConfigServer20000Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConfigServer20000Application.class, args);
    }

}
