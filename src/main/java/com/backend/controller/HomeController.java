package com.backend.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HomeController {

	@GetMapping("/teste")
	public String isAuthenticated() {
		return "FINALMENTE FUNCIONOU";
	}

	/**
	 * endpoint onde o usuario tem que ter a role admin
	 */
	@GetMapping(value = "/admin")
	@PreAuthorize("hasRole('admin')")
	public String isAdmin() {
		return "EU SOU ADMIN";
	}
	
	@GetMapping(value = "/user")
	@PreAuthorize("hasRole('user')")
	public String isUser() {
		return "EU SOU USUARIO";
	}
}
