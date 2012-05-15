package com.ebi.formation.mfb.web.controller.errors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Page500 {

	@RequestMapping("/500.php")
	public String redirect() {
		return "page500";
	}
}
