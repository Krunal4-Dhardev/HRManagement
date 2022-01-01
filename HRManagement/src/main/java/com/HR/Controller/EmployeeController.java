package com.HR.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HR.Bean.Employee;
import com.HR.Service.EmployeeService;
import com.HR.Service.EmployeeServiceImpl;
import com.HR.config.EmployeeDetailsServiceImpl;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	
	// build create employee REST API
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		//Encode The Password
		employee.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
		return new ResponseEntity<Employee>(employeeServiceImpl.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	
	//Build get All Employee API
	@GetMapping
	public List<Employee> getAllEmployees()
	{	
		return employeeServiceImpl.getAllEmployees();
	}
	
	//Build get Employee By Id 
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long empId)
	{
		return new ResponseEntity<Employee>(employeeServiceImpl.getEmployeeById(empId), HttpStatus.OK);
	}
	
	//Build Updatr Employee Rest API
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long empId,@RequestBody Employee emp)
	{
		return new ResponseEntity<Employee>(employeeServiceImpl.updateEmployee(emp, empId),HttpStatus.OK);
	}
	
	//Build Delete By Employee Id
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@RequestParam Long id)
	{
		employeeServiceImpl.deleteEmployeeById(id);
		return new ResponseEntity<String>("Employee Deleted Successfully",HttpStatus.OK);
	}
}