package br.com.infogomes.analysisfinancial.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdviceExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = RuntimeException.class)
	protected String handleConflict(RuntimeException ex, Model model) {
		model.addAttribute("alert", ex.getMessage());
		return "helloworld";
	}
}
