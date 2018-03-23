package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.model.Patient;

@Repository
public interface PatientRepo  extends JpaRepository<Patient, Integer> {
	 Patient findByEmail(String email);
	 
}
