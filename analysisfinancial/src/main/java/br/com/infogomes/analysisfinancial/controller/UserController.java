package br.com.infogomes.analysisfinancial.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.infogomes.analysisfinancial.entities.User;

@Controller
@RequestMapping(path = "user")
public class UserController {
	
	@GetMapping()
	public String listUser(Model model) {
		model.addAttribute("listUser", new ArrayList<User>());
		return "user/listuser";
	}

	@GetMapping(path = "/adduser")
	public String addUser() {
		return "user/adduser";
	}
}
