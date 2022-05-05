package br.com.infogomes.analysisfinancial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.infogomes.analysisfinancial.dto.LoginDTO;

@Controller
@RequestMapping(path = "login")
public class LoginController {

	@GetMapping
	public String login(Model model) {
		model.addAttribute("user", new LoginDTO());
		return "login";
	}

}
