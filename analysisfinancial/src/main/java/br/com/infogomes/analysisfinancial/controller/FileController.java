package br.com.infogomes.analysisfinancial.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.infogomes.analysisfinancial.services.TransactionService;
import br.com.infogomes.analysisfinancial.util.CSVUtil;

@Controller
public class FileController {

	@Autowired
	private TransactionService service;

	@GetMapping("/")
	public String helloWorld() {
		return "helloworld";
	}

	@PostMapping("/")
	public String handleFileUpload(@RequestParam("formFile") MultipartFile file, RedirectAttributes redirectAttributes)
			throws IOException {
		
		if(CSVUtil.isEmpty(file.getInputStream())) {			
			throw new RuntimeException("Aquivo Vazio");
		}

		CSVUtil.readeCsv(file.getInputStream());

		service.save(CSVUtil.parseToTransactionList(file.getInputStream()));

		System.out.println("Nome do arquivo: " + file.getOriginalFilename() + " tamanho do arquivo: " + file.getSize());

		return "redirect:/";
	}

}
