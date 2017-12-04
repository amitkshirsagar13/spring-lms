package io.lms.micro.services.server.micro;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import io.lms.micro.services.server.base.BaseServer;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class BaseServer
 * Creation date: Jan 30, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

// @ComponentScan(useDefaultFilters = true, basePackages = {
// "io.lms.micro.services.server.micro" })
// @PropertySources(value = {
// @PropertySource("classpath:/application.properties") })
public class MicroBaseServer extends BaseServer {
	@Override
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("redirect:" + "/docs/index.html");
	}
}
