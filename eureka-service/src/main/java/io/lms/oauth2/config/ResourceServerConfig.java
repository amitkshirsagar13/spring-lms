// package io.lms.oauth2.config;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import
// org.springframework.boot.context.properties.EnableConfigurationProperties;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import
// org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
// import
// org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
// import
// org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
// import
// org.springframework.security.oauth2.provider.token.RemoteTokenServices;
//
/// **
// * <p>
// * <b>Overview:</b>
// * <p>
// *
// *
// * <pre>
// * &#64;projectName base-service
// * Creation date: Dec 5, 2017
// * &#64;author Amit Kshirsagar
// * &#64;version 1.0
// * &#64;since
// *
// * <p><b>Modification History:</b><p>
// *
// *
// * </pre>
// */
// @Configuration
// @EnableResourceServer
// @EnableWebSecurity
// @EnableConfigurationProperties
// public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
// @Value("${security.user.name}")
// private String userName;
//
// @Value("${security.user.password}")
// private String password;
//
// @Autowired
// public void configureGlobal(final AuthenticationManagerBuilder
// authManagerBuilder) throws Exception {
// authManagerBuilder.inMemoryAuthentication().withUser(userName).password(password).roles("ROLE");
// }
//
// @Bean
// public RemoteTokenServices remoteTokenServices() {
// final RemoteTokenServices tokenServices = new RemoteTokenServices();
// tokenServices.setCheckTokenEndpointUrl("http://localhost.shinigami.io:8761/oauth/check_token");
// tokenServices.setClientId("config");
// tokenServices.setClientSecret("password");
// return tokenServices;
// }
//
// @Override
// public void configure(ResourceServerSecurityConfigurer resources) throws
// Exception {
// resources.tokenServices(remoteTokenServices()).resourceId("config-services");
// }
//
// @Override
// public void configure(HttpSecurity http) throws Exception {
// http.authorizeRequests().anyRequest().authenticated().and().sessionManagement()
// .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();
// }
//
// }