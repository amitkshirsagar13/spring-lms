package io.lms.micro.zuul.filters;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.config.DynamicBooleanProperty;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.constants.ZuulConstants;
import com.netflix.zuul.context.RequestContext;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName zuul-service
 * &#64;class BaseBaseFilter
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
public class BaseBaseFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(BaseBaseFilter.class);

	private static final DynamicBooleanProperty ROUTING_DEBUG = DynamicPropertyFactory.getInstance()
			.getBooleanProperty(ZuulConstants.ZUUL_DEBUG_REQUEST, false);

	private static final DynamicStringProperty DEBUG_PARAMETER = DynamicPropertyFactory.getInstance()
			.getStringProperty(ZuulConstants.ZUUL_DEBUG_PARAMETER, "debug");

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public boolean shouldFilter() {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		if (!"true".equals(request.getParameter(DEBUG_PARAMETER.get()))) {
			return true;
		}
		return ROUTING_DEBUG.get();
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		if (!request.getRequestURL().toString().contains("swagger")) {
			Enumeration<String> headerNames = request.getHeaderNames();
			Map<String, String> map = new HashMap<>();
			while (headerNames.hasMoreElements()) {
				String key = headerNames.nextElement();
				String value = request.getHeader(key);
				map.put(key, value);
			}
			log.info(String.format("Header details: %s", map.toString()));
			log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
			ctx.setDebugRouting(true);
			ctx.setDebugRequest(true);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netflix.zuul.ZuulFilter#filterOrder()
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

}
