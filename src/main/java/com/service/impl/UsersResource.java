package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PatientRepo;
import com.model.Patient;
import com.service.UserService;

@Service("userService")
public class UsersResource implements UserService{
	
	@Autowired
	private PatientRepo patientRepo;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Patient user = patientRepo.finByEmail(email);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
    
  
    public List<Patient> persist(final Patient patients) {
        patientRepo.save(patients);
        return patientRepo.findAll();
    }   
    
   
    public List<Patient> getAll() {
    	System.out.println("Data Fach");
        return patientRepo.findAll();
    }
 
	
	public void deleteUser1(Integer id) {
			patientRepo.delete(id);
		}
	
	
    public Patient patientId(Integer id) {
        return patientRepo.findOne(id);
    }
    
    public Patient patientEmail(String email) {
		return patientRepo.findByEmail(email);
    	
    }
 	
	
	public Patient updateUser(Patient user,Integer id) {
		
		Patient modifiedUser= patientRepo.findOne(id);
		modifiedUser.setFirstName(user.getFirstName());
		modifiedUser.setLastName(user.getLastName());
		modifiedUser.setEmail(user.getEmail());
		modifiedUser.setPassword(user.getPassword());
		modifiedUser.setGender(user.getGender());
		modifiedUser.setUser(user.getUser());
		return patientRepo.save(modifiedUser);
	}


	
}