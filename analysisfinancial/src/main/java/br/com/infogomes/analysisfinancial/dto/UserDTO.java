package br.com.infogomes.analysisfinancial.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDTO {

	private Long id;
	@NotBlank(message = "Nome obrigatório")
	private String userName;
	@Column(unique = true)
	@NotBlank(message = "Email obrigatório")
	@Email
	private String email;

	public UserDTO() {
		super();
	}

	public UserDTO(Long id, String userName, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
