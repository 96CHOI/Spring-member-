package com.dw.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberPageController {
	@GetMapping("/member")
	public String callmemberPage() {

		return "member";
	}

	@GetMapping("/login")
	public String loadLoginPage() {
		return "login";
	}

	@GetMapping(value = { "/", "/home" })
	public String loadHomePage() {
		return "member";
	}
}
