package com.forezp.filter;

import com.netflix.zuul.ZuulFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

/**
 * Created by forezp on 2017/8/3.
 */
@Component
public class LoggerFilter extends ZuulFilter {

    @Autowired
    Tracer tracer;
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 900;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        tracer.currentSpan().tag("operator", "forezp"); // MIGRATED: tracer.addTag() removed in Spring Cloud Sleuth 3.x; use tracer.currentSpan().tag()
        System.out.print(tracer.currentSpan().context().traceId()); // MIGRATED: getCurrentSpan().traceIdString() replaced with currentSpan().context().traceId() in Spring Cloud Sleuth 3.x
        return null;
    }
}
