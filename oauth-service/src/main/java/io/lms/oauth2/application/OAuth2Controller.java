package io.lms.oauth2.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.lms.oauth2.model.AuthorityEntity;
import io.lms.oauth2.model.Greeting;
import io.lms.oauth2.model.Response;
import io.lms.oauth2.service.AuthorityService;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName oauth-service
 * Creation date: Dec 5, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */
@Controller
public class OAuth2Controller {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

	@RequestMapping(value = "/addAuthority", method = RequestMethod.GET)
	public String addRole(Model model) {
		model.addAttribute("authorityForm", new AuthorityEntity());
		model.addAttribute("response",
				new Response<List<AuthorityEntity>>().setResponseItem(authorityService.getAllAuthorities()));
		return "addAuthority";
	}

	@Autowired
	private AuthorityService authorityService;

	@RequestMapping(value = "/addAuthorityResult", method = RequestMethod.POST)
	public String addAuthorityResult(Model model, @ModelAttribute(name = "authorityForm") AuthorityEntity authority) {
		authorityService.saveAuthority(authority);
		model.addAttribute("response",
				new Response<List<AuthorityEntity>>().setResponseItem(authorityService.getAllAuthorities()));
		return "addAuthority";
	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String result(@ModelAttribute Greeting greeting) {
		System.out.println(greeting.getContent());
		return "result";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String root(Model model) {
		model.addAttribute("greeting", new Greeting());
		return "home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("greeting", new Greeting());
		return "home";
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error(Model model) {
		return "error";
	}
}
