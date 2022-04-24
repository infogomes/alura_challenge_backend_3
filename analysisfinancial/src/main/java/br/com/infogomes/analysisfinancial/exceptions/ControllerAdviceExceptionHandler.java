package br.com.infogomes.analysisfinancial.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class ControllerAdviceExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = RuntimeException.class)
	protected String handleConflict(RuntimeException ex, Model model, RedirectAttributes redirectAttrs) {

		redirectAttrs.addFlashAttribute("alert", ex.getMessage());
		return "redirect:/";
	}
}
