package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.model.Patient;
import com.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest")
@Component
public class UserController{
	
	@Autowired
	private UserService userService;
	
	/*@Autowired
	private BCryptPasswordEncoder bcryptEncoder;*/
	
	/*public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Patient user = patientRepo.finByEmail(email);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}*/
    
   @PostMapping(value = "/users/loadP")
    public List<Patient> persist1(@RequestBody final Patient patients) {
        return userService.persist(patients);
    }   
    
    @RequestMapping(value = "/users/all", method = RequestMethod.GET)
    public List<Patient> getAll1() {
        return userService.getAll();
    }
 
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteUser1(@PathVariable(value="id") Integer id) {
		userService.deleteUser1(id);
	}
	
	@GetMapping(value = "/update/{id}")
    public Patient patientId1(@PathVariable Integer id) {
        return userService.patientId(id);
    }
    
   
	public Patient findOne(String email) {
		return userService.patientEmail(email);
	}
	
	@RequestMapping(value = "/update1/{id}" ,method = RequestMethod.PUT)
	public Patient updateUser1(@RequestBody Patient user,@PathVariable Integer id) {
		return userService.updateUser(user, id);
	}
 
    
}
