package com.ebi.formation.mfb.web.controller.errors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Errors {

	@RequestMapping("404.php")
	public String error404() {
		return "page404";
	}

	@RequestMapping("500.php")
	public String error500() {
		return "page500";
	}
}
