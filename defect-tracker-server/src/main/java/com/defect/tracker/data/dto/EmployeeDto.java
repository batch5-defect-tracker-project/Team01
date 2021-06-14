package com.defect.tracker.data.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
	private Long id;
	@NotNull(message = "{employee.name.null}")
	@NotEmpty(message = "{employee.name.empty}")
	@NotBlank(message = "{employee.name.blank}")
	@Pattern(regexp = "^[a-zA-Z.\\-\\/+=@_ ]*$", message = "{employee.name.notallow.specialcharacters}")
	private String name;
	@NotNull(message = "{employee.email.null}")
	@NotEmpty(message = "{employee.email.empty}")
	@NotBlank(message = "{employee.email .blank}")
	@Email(message = "{employee.email.invalid}")
	@Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", message = "{employee.email.syntaxerror}")
	private String email;
	@NotNull(message = "{employee.password.null}")
	@NotEmpty(message = "employee.password.empty}")
	@NotBlank(message = "{employee.password.blank}")
	private String password;
	@NotNull(message = "{employee.gender.null}")
	@NotEmpty(message = "{employee.gender.empty}")
	@NotBlank(message = "{employee.gender.blank}")
	@Pattern(regexp = "^[a-zA-Z.\\-\\/+=@_ ]*$", message = "{employee.gender.notallow.specialcharacters}")
	private String gender;
	@NotNull(message = "{employee.contactnumber.null}")
	@Positive(message = "{employee.contactnumber.onlypositive.number}")
	private Long contactNumber;
	@NotNull(message = "{employee.status.blank}")
	private boolean isEnabled;
	@NotNull(message = "{employee.designationId.null}")
	private Long designationId;

}
