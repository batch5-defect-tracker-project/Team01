package com.defect.tracker.data.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogInDto {

	@NotNull(message = "{login.email.null}")
	@NotEmpty(message = "{login.email.empty}")
	@NotBlank(message = "{login.email.blank}")
	@Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", message = "{login.email.syntaxerror}")
	private String userName;
	@NotNull(message = "{login.password.null}")
	@NotEmpty(message = "{login.password.empty}")
	@NotBlank(message = "{login.password.blank}")
	private String password;

	public LogInDto() {

	}

	public LogInDto(String userName, String password) {
		this.setUserName(userName);
		this.setPassword(password);
	}

}
