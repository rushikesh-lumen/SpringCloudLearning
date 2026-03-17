package com.forezp.filter;

// MIGRATED: ZuulFilter -> GlobalFilter (Spring Cloud Gateway)
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer; // MIGRATED: Tracer API in Spring Cloud Sleuth 3.x
import org.springframework.stereotype.Component;

/**
 * MIGRATED: ZuulFilter -> GlobalFilter (Spring Cloud Gateway)
 * Created by forezp on 2017/8/3.
 */
@Component
public class LoggerFilter implements GlobalFilter, Ordered { // MIGRATED: extends ZuulFilter -> implements GlobalFilter, Ordered

    @Autowired
    Tracer tracer;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) { // MIGRATED: run() -> filter()
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Tracer.SpanInScope scope = tracer.withSpan(tracer.currentSpan()); // MIGRATED: tracer.getCurrentSpan() -> tracer.currentSpan()
            try (scope) {
                tracer.currentSpan().tag("operator", "forezp"); // MIGRATED: tracer.addTag() -> tracer.currentSpan().tag()
                System.out.print(tracer.currentSpan().context().traceId()); // MIGRATED: traceIdString() -> traceId()
            }
        }));
    }

    @Override
    public int getOrder() { // MIGRATED: filterOrder() -> getOrder()
        return 900;
    }
}
