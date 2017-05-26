package com.yingyue.ihorse.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

	@RequestMapping(path = "to_login", method = RequestMethod.GET)
	public ModelAndView toLogin() {
		ModelAndView model = new ModelAndView("signin");
		return model;
	}
}
