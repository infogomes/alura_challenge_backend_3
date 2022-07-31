package br.com.infogomes.analysisfinancial.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class LoginDTO {

	@NotBlank(message = "Email obrigatório")
	@Email
	private String username;

	@NotBlank(message = "Senha obrigatório")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
