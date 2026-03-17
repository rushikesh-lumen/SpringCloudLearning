package com.forezp;

// MIGRATED: ZuulFilter -> GlobalFilter (Spring Cloud Gateway)
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * MIGRATED: ZuulFilter -> GlobalFilter (Spring Cloud Gateway)
 * Original logic preserved: checks for 'token' parameter and rejects requests without it.
 */
@Component
public class MyFilter implements GlobalFilter, Ordered { // MIGRATED: extends ZuulFilter -> implements GlobalFilter, Ordered

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) { // MIGRATED: run() -> filter(ServerWebExchange, GatewayFilterChain)
        String method = exchange.getRequest().getMethod().name();
        String url = exchange.getRequest().getURI().toString();
        log.info(String.format("%s >>> %s", method, url));
        String accessToken = exchange.getRequest().getQueryParams().getFirst("token"); // MIGRATED: RequestContext -> ServerWebExchange
        if (accessToken == null) {
            log.warn("token is empty");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED); // MIGRATED: ctx.setResponseStatusCode(401)
            return exchange.getResponse().setComplete();
        }
        log.info("ok");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() { // MIGRATED: filterOrder() -> getOrder()
        return 0;
    }
}
