package com.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = { "/" })
public class PageInitController {

	@RequestMapping(value = {"/login"})
	public String login() {
		return "login";
	}

	@PostMapping(value = { "/loginAction" })
	public String loginAction() {
		return "redirect:/product";
	}

	@GetMapping("/login?error")
	public String login(Model model) {
		model.addAttribute("errorMessage", "Login failed!");
		return "login";
	}
}