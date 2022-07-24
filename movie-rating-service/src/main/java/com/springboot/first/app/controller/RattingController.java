package com.springboot.first.app.controller;

import com.springboot.first.app.UserRatting;
import com.springboot.first.app.attributeSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.first.app.Ratting;

import javax.annotation.security.RolesAllowed;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
public class  RattingController {



	@GetMapping("/ratting/{movieId}")
	public Ratting getRatting( @PathVariable("movieId") String movieId) {
		return new Ratting(movieId,5);
	}


	@GetMapping("/ratting/user/{userId}")
	public UserRatting getRattingMovie( @PathVariable("userId") String userId) {

		List<Ratting> rattings = Arrays.asList(
				new Ratting("5",5),
				new Ratting("6",3),
				new Ratting("3",4)
		);

		UserRatting userRatting = new UserRatting();
		userRatting.setUserRatting(rattings);

		return userRatting;
	}

	// @Value features
	@Value("${attribute.value}")
	private String valueAtt;

	@Value("${attribute.list}")
	private List<String> ValueList;

	//@Value("#{${attribute.object}}")
	//private Map<String,String> ValueObject;

	@GetMapping("value")
	public String getValue( ) {
		return valueAtt;
	}
	@GetMapping("valuelist")
	public List<String> getValueList( ) {
		return ValueList;
	}

	//@GetMapping("valueobjet")
	//public Map<String, String> getValueObject( ) {
	//	return ValueObject;
	//}

	// @Configuration properties features


	@Autowired
	private attributeSettings attSettings ;

	@GetMapping("configprop")
	public String getAllAttributeObject( ) {
		return attSettings.getValue() + attSettings.getList();
	}


	@Autowired
	/*
	Interface representing the environment in which the current application is running.
	 Models two key aspects of the application environment: profiles and properties.
	 Methods related to property access are exposed via the PropertyResolver superinterface.

    A profile is a named, logical group of bean definitions to be registered with the container
     only if the given profile is active. Beans may be assigned to a profile whether defined
     in XML or via annotations; see the spring-beans 3.1 schema or the @Profile annotation
     for syntax details. The role of the Environment object with relation to profiles is in
     determining which profiles (if any) are currently active, and which profiles (if any)
     should be active by default.

   Properties play an important role in almost all applications, and may originate from a
    variety of sources: properties files, JVM system properties, system environment variables,
    JNDI, servlet context parameters, ad-hoc Properties objects, Maps, and so on. The role of the
    Environment object with relation to properties is to provide the user with a convenient service
    interface for configuring property sources and resolving properties from them.
 */
	// not practical to used (not recommended )
	private Environment env;

	@GetMapping("/envdetails")
	public String envDetails(){
		return env.toString();
	}

}
