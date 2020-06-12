package com.my.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/page/{var}")
	public String page(@PathVariable("var") String var) {
		String returnUrl = "";
		if(var.equals("one")) {
			returnUrl = "page1";
		}else if (var.equals("two")) {
			returnUrl = "page2";
		}
		return returnUrl;
	}
	
	@RequestMapping("/byGet")
	public String resultByGet(String key1, String key2, Model model) {
		System.out.println("Get key 1 : " + key1);
		System.out.println("Get key 2 : " + key2);
		
		model.addAttribute("key1", key1);
		model.addAttribute("key2", key2);
		return "path";
	}
	
	@RequestMapping("/byPath/{key1}/{key2}")
	public String resultByPath(@PathVariable String key1, @PathVariable String key2) {
		System.out.println("Path key 1 :: " + key1);
		System.out.println("Path key 2 :: " + key2);
		return "path";
	}
	
	@RequestMapping("/byPath/key1/{key1}/key2/{key2}")
	public String resultByPath2(@PathVariable String key1, @PathVariable String key2) {
		System.out.println("Path key 1 :: " + key1);
		System.out.println("Path key 2 :: " + key2);
		return "path";
	}
	
}
