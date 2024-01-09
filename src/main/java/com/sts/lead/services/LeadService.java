package com.sts.lead.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.lead.entities.Lead;
import com.sts.lead.model.ErrorResponse;
import com.sts.lead.model.LeadDTO;
import com.sts.lead.model.LeadResponse;
import com.sts.lead.repository.LeadRepository;

@Service
public class LeadService{

	 private final LeadRepository leadRepository;

	    @Autowired
	    public LeadService(LeadRepository leadRepository) {
	        this.leadRepository = leadRepository;
	    }

	    public LeadResponse createLead(LeadDTO leadDTO) {
	        if (leadRepository.existsByLeadId(leadDTO.getLeadId())) {
	            return new LeadResponse("error", new ErrorResponse("E10010", "Lead Already Exists in the database with the lead id"));
	        }

	        Lead lead = new Lead();
	        lead.setLeadId(leadDTO.getLeadId());
	        lead.setFirstName(leadDTO.getFirstName());
	        lead.setMiddleName(leadDTO.getMiddleName());
	        lead.setLastName(leadDTO.getLastName());
	        lead.setMobileNumber(leadDTO.getMobileNumber());
	        lead.setGender(leadDTO.getGender());
	        lead.setDOB(leadDTO.getDob());
	        lead.setEmail(leadDTO.getEmail());

	        leadRepository.save(lead);

	        return new LeadResponse("success", "Created Leads Successfully");
	    }
	    
	 // Method to get leads by mobile number
	    public List<Lead> getLeadsByMobileNumber(String mobileNumber) {
	        return leadRepository.findByMobileNumber(mobileNumber);
	    }
}
