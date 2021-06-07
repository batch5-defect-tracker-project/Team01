package com.defect.tracker.data.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class LogInDto {
	@NotNull(message = "{login.email.null}")
	@NotEmpty(message = "{login.email.empty}")
	@NotBlank(message = "{login.email.blank}")
	@Email(message = "{login.email.invalid}")
	@Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", message = "{login.email.syntaxerror}")
	private String userName;
	@NotNull(message = "{login.password.null}")
	@NotEmpty(message = "{login.password.empty}")
	@NotBlank(message = "{login.password.blank}")
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
