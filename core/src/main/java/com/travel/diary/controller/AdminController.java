package com.travel.diary.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

	@GetMapping("/admin/interval")
	public String admin(Model model) {
		return "admin";
	}
}
