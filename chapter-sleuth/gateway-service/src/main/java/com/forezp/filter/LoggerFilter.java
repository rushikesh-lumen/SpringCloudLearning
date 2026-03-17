package com.forezp.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * MIGRATED: Converted from Zuul ZuulFilter to Spring Cloud Gateway GlobalFilter
 * Original: post-type Zuul filter using Sleuth Tracer to add tags
 */
@Component
public class LoggerFilter implements GlobalFilter, Ordered {

    private static Logger log = LoggerFactory.getLogger(LoggerFilter.class);

    @Autowired
    Tracer tracer;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // MIGRATED: Using new Spring Cloud Sleuth 3.x Tracer API
        if (tracer.currentSpan() != null) {
            tracer.currentSpan().tag("operator", "forezp"); // MIGRATED: replaced tracer.addTag() with tracer.currentSpan().tag()
            log.info("traceId: " + tracer.currentSpan().context().traceId()); // MIGRATED: replaced traceIdString() with context().traceId()
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 900; // MIGRATED: replaced filterOrder() with getOrder() from Ordered interface
    }
}
