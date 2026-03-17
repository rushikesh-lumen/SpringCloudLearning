package com.forezp.servicezuul.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * MIGRATED: Converted from Zuul ZuulFilter to Spring Cloud Gateway GlobalFilter
 * Original: pre-type Zuul filter checking for 'token' request parameter
 */
@Component
public class MyFilter implements GlobalFilter, Ordered {

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // MIGRATED: replaced RequestContext/ZuulFilter with ServerWebExchange/GlobalFilter
        String method = exchange.getRequest().getMethod() != null ? exchange.getRequest().getMethod().name() : "UNKNOWN";
        String url = exchange.getRequest().getURI().toString();
        log.info(String.format("%s >>> %s", method, url));

        String accessToken = exchange.getRequest().getQueryParams().getFirst("token");
        if (accessToken == null) {
            log.warn("token is empty");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED); // MIGRATED: replaced ctx.setResponseStatusCode(401)
            return exchange.getResponse().setComplete();
        }
        log.info("ok");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0; // MIGRATED: replaced filterOrder() with getOrder() from Ordered interface
    }
}
