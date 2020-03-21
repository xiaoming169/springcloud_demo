package xiaoming.zixue.springcloud_gateway_18000.gateway;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import xiaoming.zixue.springcloud_gateway_18000.filter.MyFilter;

/**
 * @Author Administrator
 * @Date 2020/3/20
 * @Version 1.0
 */
@Configuration
public class GatewayConfiguration {

    @Bean(name = "remoteAddrKeyResolver")
    public KeyResolver getKeyResolver(){
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                return Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
            }
        };
    }

    /**
     * 配置全局过滤器
     * @return
     */
//    @Bean
    public GlobalFilter getGlobalFilter(){
        return new MyFilter();
    }

}
