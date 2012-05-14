package com.ebi.formation.mfb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Login {

	@RequestMapping("/login.htm")
	public String redirect() {
		return "login";
	}
}
