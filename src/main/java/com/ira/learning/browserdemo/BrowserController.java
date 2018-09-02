package com.ira.learning.browserdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BrowserController {

	@Autowired
	private BrowserService service;

	@RequestMapping(value = "/welcome")
	public String showWelcomePage() {
		return "welcome";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String handleSearchRequest(@RequestParam String query, ModelMap model) {

		// System.out.println("query = " + query);
		if (query.equalsIgnoreCase("Mercury")) {
			// System.out.println("Go to mercury page");
			return "Mercury";
		}

		model.put("errorMessage", "No such match found! Please change keywords.");
		// System.out.println("Go to welcome page");
		return "welcome";

	}

}