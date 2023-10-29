package com.chuvakov.hockeymanager.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HockeyController {

	@RequestMapping(value = { "/", "/home" })
	public String home() {
		return "home";
	}

}
