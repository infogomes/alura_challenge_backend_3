package br.com.infogomes.analysisfinancial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileController {

	@GetMapping("/")
	public String helloWorld() {
		return "helloworld";
	}

	@PostMapping("/")
	public String handleFileUpload(@RequestParam("formFile") MultipartFile file, RedirectAttributes redirectAttributes) {

		System.out.println("Nome do arquivo: "+file.getOriginalFilename() + " tamanho do arquivo: "+ file.getSize());

		return "redirect:/";
	}

}
