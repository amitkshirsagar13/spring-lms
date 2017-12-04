package io.lms.micro.zuul.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName zuul-service
 * &#64;class BasicAuthorizationHeaderFilter
 * Creation date: Feb 13, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */
@Component
public class BasicAuthorizationHeaderFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(BasicAuthorizationHeaderFilter.class);

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 10;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {

		RequestContext ctx = RequestContext.getCurrentContext();
		ctx.getRequest().getRequestURL();
		// log.info("Autherization Token Passed: " +
		// ctx.getRequest().getHeader("Authorization"));
		ctx.addZuulRequestHeader("Authorization", ctx.getRequest().getHeader("Authorization"));
		return null;
	}

}
