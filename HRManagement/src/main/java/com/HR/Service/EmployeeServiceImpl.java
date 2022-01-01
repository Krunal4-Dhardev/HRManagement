package com.HR.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HR.Bean.Employee;
import com.HR.Exception.ResourceNotFoundException;
import com.HR.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public List<Employee> getAllEmployees() {	
		return empRepo.findAll();
	}

	 @Override
	public Employee saveEmployee(Employee emp) {
		return empRepo.save(emp);
	}
	 
	 @Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> emp = empRepo.findById(id);
		if(emp.isPresent())
		{
			return emp.get();
		}
		else
		{
			throw new ResourceNotFoundException("Employee", "ID", id);
		}
	}
	 
	@Override
	public Employee updateEmployee(Employee emp, long id) {
	
		//First Check whether Employee with given Id is exist in DB
		
		Employee existingEmployee=empRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "ID", id));

		existingEmployee.setFirstName(emp.getFirstName());
		existingEmployee.setLastName(emp.getLastName());
		existingEmployee.setEmail(emp.getEmail());
		existingEmployee.setDesignation(emp.getDesignation());
		existingEmployee.setHireDate(emp.getHireDate());
		existingEmployee.setPassword(emp.getPassword());
		existingEmployee.setPhoneNo(emp.getPhoneNo());
		existingEmployee.setSalary(emp.getSalary());
		
		//save Existing Employee
		empRepo.save(existingEmployee);
		
		return existingEmployee;
	}
	
	@Override
	public void deleteEmployeeById(Long id) {
		//check Employee Id is exist or Not
		empRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "ID", id));
		
		empRepo.deleteById(id);		
	}
}
