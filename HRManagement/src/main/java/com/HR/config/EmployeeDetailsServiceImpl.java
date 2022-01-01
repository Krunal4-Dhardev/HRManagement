package com.HR.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.HR.Bean.Employee;
import com.HR.Repository.EmployeeRepository;

public class EmployeeDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		//Fatching user from Databse

		 Employee emp= employeeRepository.getEmployeeByEmail(email);
		
		 if(emp==null)
		 {
			 throw new UsernameNotFoundException("Could not Found Employee !!");
		 }
		 
		 CustomEmployeeDetails customEmployeeDetails=new CustomEmployeeDetails(emp);
		 return customEmployeeDetails;
	}

	
}
