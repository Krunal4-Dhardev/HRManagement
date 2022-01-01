package com.HR.Service;

import java.util.List;

import com.HR.Bean.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee emp);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(Long id);
	Employee updateEmployee(Employee emp,long id);
	void deleteEmployeeById(Long id);
}
