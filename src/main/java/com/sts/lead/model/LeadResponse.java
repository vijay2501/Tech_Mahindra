package com.sts.lead.model;


import java.util.List;

import com.sts.lead.entities.Lead;

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
public class LeadResponse {

	private String status;
    private Object data; // Use Object to handle both List<Lead> and ErrorResponse

    // Constructors, getters, and setters

    // Constructor for success response
    public LeadResponse(String status, List<Lead> data) {
        this.status = status;
        this.data = data;
    }

    // Constructor for error response
    public LeadResponse(String status, ErrorResponse errorResponse) {
        this.status = status;
        this.data = errorResponse;
    }
}
