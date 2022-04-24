package br.com.infogomes.analysisfinancial.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.infogomes.analysisfinancial.entities.Importation;
import br.com.infogomes.analysisfinancial.entities.Transaction;
import br.com.infogomes.analysisfinancial.services.ImportationService;
import br.com.infogomes.analysisfinancial.services.TransactionService;
import br.com.infogomes.analysisfinancial.util.CSVUtil;

@Controller
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private ImportationService importationService;

	@GetMapping("/")
	public String home(Model model) {

		List<Importation> listImportation = importationService.findAll();
		model.addAttribute("listImportation", listImportation);

		return "home";
	}

	@PostMapping("/")
	public String handleFileUpload(@RequestParam("formFile") MultipartFile file, Model model) throws IOException {

		List<Transaction> listTransaction = transactionService
				.save(CSVUtil.parseToListTransaction(file.getInputStream()));

		LocalDate transactionDate = listTransaction.get(0).getTime().toLocalDate();

		importationService.save(new Importation(transactionDate, LocalDateTime.now()));

		return "redirect:/";
	}

}
