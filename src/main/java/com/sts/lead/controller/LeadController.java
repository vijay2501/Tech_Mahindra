package com.sts.lead.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.lead.entities.Lead;
import com.sts.lead.model.ErrorResponse;
import com.sts.lead.model.LeadDTO;
import com.sts.lead.model.LeadResponse;
import com.sts.lead.repository.LeadRepository;
import com.sts.lead.services.LeadService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/leads")
@Validated
public class LeadController {
	
	 private final LeadService leadService;

	  @Autowired
	    private LeadRepository leadRepository;
	  
	    @Autowired
	    public LeadController(LeadService leadService) {
	        this.leadService = leadService;
	    }

	    @PostMapping
	    public ResponseEntity<Object> createLead(@Valid @RequestBody LeadDTO leadDTO) {
	        LeadResponse response = leadService.createLead(leadDTO);

	        if ("success".equals(response.getStatus())) {
	            return new ResponseEntity<>(response, HttpStatus.CREATED);
	        } else {
	            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	        }
	    }
	    
	    @GetMapping("/mobile/{mobileNumber}")
	    public ResponseEntity<LeadResponse> getLeadsByMobileNumber(@PathVariable String mobileNumber) {
	        List<Lead> leads = leadService.getLeadsByMobileNumber(mobileNumber);

	        if (leads.isEmpty()) {
	            ErrorResponse errorResponse = new ErrorResponse("E10011", "No Lead found with the Mobile Number " + mobileNumber);
	            return new ResponseEntity<>(new LeadResponse("error", errorResponse), HttpStatus.NOT_FOUND);
	        } else {
	            return new ResponseEntity<>(new LeadResponse("success", leads), HttpStatus.OK);
	        }
	   }
}
