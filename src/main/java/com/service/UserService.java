package com.service;

import java.util.List;

import com.model.Patient;

public interface UserService {
	
	 public List<Patient> persist(final Patient patients);

	 public List<Patient> getAll();
	 
	 public void deleteUser1(Integer id);
	 
	 public Patient patientId(Integer id);
	 
	 public Patient patientEmail(String email);
	 
	 public Patient updateUser(Patient user,Integer id);
}
