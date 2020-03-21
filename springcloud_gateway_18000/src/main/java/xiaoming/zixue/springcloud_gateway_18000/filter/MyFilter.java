package xiaoming.zixue.springcloud_gateway_18000.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author Administrator
 * @Date 2020/3/20
 * @Version 1.0
 */
public class MyFilter implements GlobalFilter, Ordered {

    /**
     * 过滤的方法
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println(exchange.getRequest().getURI().getPath());
        Mono<Void> filter = chain.filter(exchange);
        return filter;
    }

    /**
     * 排序的方法,值越大，优先级越低
     * @return
     */
    @Override
    public int getOrder() {
        return 100;
    }
}
