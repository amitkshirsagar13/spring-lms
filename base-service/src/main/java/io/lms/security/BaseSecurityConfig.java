// package io.lms.security;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import
// org.springframework.boot.context.properties.EnableConfigurationProperties;
// import org.springframework.boot.web.servlet.FilterRegistrationBean;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import
// org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.builders.WebSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
/// **
// *
// * <p>
// * <b>Overview:</b>
// * <p>
// *
// *
// * <pre>
// * &#64;projectName base-service
// * Creation date: Dec 6, 2017
// * &#64;author Amit Kshirsagar
// * &#64;version 1.0
// * &#64;since
// *
// * <p><b>Modification History:</b><p>
// *
// *
// * </pre>
// */
//
// @Configuration
// @EnableWebSecurity
// @EnableConfigurationProperties
// @EnableGlobalMethodSecurity(prePostEnabled = true)
// public class BaseSecurityConfig extends WebSecurityConfigurerAdapter {
// @Value("${security.user.name}")
// private String userName;
//
// @Value("${security.user.password}")
// private String password;
//
// @Autowired
// private BaseBasicAuthenticationEntryPoint authenticationEntryPoint;
// @Autowired
// private BaseBasicAuthenticationFilter authFilter;
//
// @Override
// protected void configure(HttpSecurity http) throws Exception {
// /**
// * Swagger UI calls dont work because of single quotes headers. if changed to
// * double quotes should work.
// */
// http.csrf().disable().cors().disable().httpBasic().disable();
// http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
// }
//
// @Override
// protected void configure(AuthenticationManagerBuilder authManagerBuilder)
// throws Exception {
// authManagerBuilder.inMemoryAuthentication().withUser(userName).password(password).roles("USER");
// }
//
// @Bean
// public FilterRegistrationBean filterRegistrationBean() {
// FilterRegistrationBean registrationBean = new FilterRegistrationBean();
// registrationBean.setFilter(authFilter);
// registrationBean.setEnabled(true);
// registrationBean.addUrlPatterns("/api/**");
// return registrationBean;
// }
//
// @Override
// public void configure(WebSecurity web) throws Exception {
// web.ignoring().antMatchers("/hystrix.stream");
// web.ignoring().antMatchers("/turbine.stream");
// }
// }
