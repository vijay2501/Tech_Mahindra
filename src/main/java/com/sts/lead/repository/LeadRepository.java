package com.sts.lead.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sts.lead.entities.Lead;

@Repository
 public interface LeadRepository extends JpaRepository<Lead,Integer> {
	
	boolean existsByLeadId(Integer leadId);
    List<Lead> findByMobileNumber(String mobileNumber);
}
