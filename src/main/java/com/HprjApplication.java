package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import com.config.RESTFulCORSFilter;


@SpringBootApplication(scanBasePackages = { "com.*"})
public class HprjApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HprjApplication.class, args);
		someFilterRegistration();
	}

	public static FilterRegistrationBean someFilterRegistration() {
		RESTFulCORSFilter filter = new RESTFulCORSFilter();
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(filter);
		registration.addUrlPatterns("/*");
		// registration.addInitParameter("paramName", "paramValue");
		registration.setName("CORS Filter");
		registration.setOrder(1);
		return registration;
	}
}
