package xiaoming.zixue.springcloud_gateway_18000.routes;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.UriSpec;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

/**
 * @Author Administrator
 * @Date 2020/3/20
 * @Version 1.0
 */
//@Configuration
public class MyRoutes {

    @Bean
    public RouteLocator getRoutelocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route(new Function<PredicateSpec, Route.AsyncBuilder>() {
                    @Override
                    public Route.AsyncBuilder apply(PredicateSpec predicateSpec) {
                        return predicateSpec
                                .path("/ribbon/**")
                                .filters(new Function<GatewayFilterSpec, UriSpec>() {
                                    @Override
                                    public UriSpec apply(GatewayFilterSpec gatewayFilterSpec) {
                                        return gatewayFilterSpec.stripPrefix(1);
                                    }
                                })
                                .uri("lb://CONSUMER-RIBBON")
                                .id("consumer1");
                    }
                })
                .route(new Function<PredicateSpec, Route.AsyncBuilder>() {
                    @Override
                    public Route.AsyncBuilder apply(PredicateSpec predicateSpec) {
                        return predicateSpec
                                .path("/feign/**")
                                .filters(new Function<GatewayFilterSpec, UriSpec>() {
                                    @Override
                                    public UriSpec apply(GatewayFilterSpec gatewayFilterSpec) {
                                        return gatewayFilterSpec.stripPrefix(1);
                                    }
                                })
                                .uri("lb://CONSUMER-FEIGN")
                                .id("consumer2");
                    }
                })
                .build();
    }

}
