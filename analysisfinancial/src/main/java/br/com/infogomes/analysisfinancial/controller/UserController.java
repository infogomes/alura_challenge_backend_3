package br.com.infogomes.analysisfinancial.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.infogomes.analysisfinancial.dto.UserDTO;
import br.com.infogomes.analysisfinancial.entities.User;
import br.com.infogomes.analysisfinancial.services.UserService;

@Controller
@RequestMapping(path = "user")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping()
	public String listUser(Model model) {
		List<UserDTO> listUser = service.findAll().stream().map(user -> userToDTO(user)).collect(Collectors.toList());

		model.addAttribute("listUser", listUser);
		return "user/listuser";
	}

	@GetMapping(path = "/adduser")
	public String addUser(Model model) {
		model.addAttribute("user", new UserDTO());
		return "user/adduser";
	}

	@PostMapping("/adduser")
	public String saveUser(@Valid @ModelAttribute UserDTO userDTO, BindingResult result, Model model) {

		User user = service.save(dtoToUser(userDTO));

		model.addAttribute("user", user);
		return "redirect:/user";
	}

	private User dtoToUser(UserDTO dto) {
		return new User(null, dto.getUserName(), dto.getEmail(), null);
	}

	private UserDTO userToDTO(User user) {
		return new UserDTO(user.getId(), user.getUserName(), user.getEmail());
	}
}
