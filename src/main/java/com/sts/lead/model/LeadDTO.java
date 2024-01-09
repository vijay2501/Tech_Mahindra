package com.sts.lead.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
public class LeadDTO {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer leadId;
	
    @NotBlank(message = "First name is mandatory")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name should contain only alphabets")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z]*$", message = "Middle name should contain only alphabets")
    private String middleName;

    @NotBlank(message = "Last name is mandatory")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name should contain only alphabets")
    private String lastName;

    @NotBlank(message = "Mobile number is mandatory")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid mobile number")
    private String mobileNumber;

    @NotBlank(message = "Gender is mandatory")
    @Pattern(regexp = "^(Male|Female|Others)$", message = "Invalid gender")
    private String gender;

    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Invalid date of birth format. Use DD/MM/YYYY.")
    private String dob;

    @Email(message = "Invalid email format")
    private String email;

}


