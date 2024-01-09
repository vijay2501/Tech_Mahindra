package com.sts.lead.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_LEAD_DETAILS")
@Data
@Getter
@Setter
public class Lead {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leadId;
	
	@Column(name = "first_Name")
	private String firstName ;
	
	
	@Column(name = "middle_Name")
	private String middleName ;
	
	@Column(name = "last_Name")
	private String lastName ;

	@Column(name = "MobileNumber")
	private String mobileNumber;

	
	@Column(name = "gender")
	private String Gender;
	
	
	@Column(name = "DateBirth")
	private String DOB;
	
	
	@Column(name = "Email")
	private String email;
	
	 // Default constructor for JPA
    public Lead() {
    }

	public Lead(int leadId, String firstName, String middleName, String lastName, String mobileNumber, String gender,
			String dOB, String email) {
		super();
		this.leadId = leadId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		Gender = gender;
		DOB = dOB;
		this.email = email;
	}

   
}
