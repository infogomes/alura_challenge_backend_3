package br.com.infogomes.analysisfinancial.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.infogomes.analysisfinancial.services.TransactionService;
import br.com.infogomes.analysisfinancial.util.CSVUtil;

@Controller
public class TransactionController {

	@Autowired
	private TransactionService service;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@PostMapping("/")
	public String handleFileUpload(@RequestParam("formFile") MultipartFile file, Model model) throws IOException {

		service.save(CSVUtil.parseToListTransaction(file.getInputStream()));

		return "home";
	}

}
