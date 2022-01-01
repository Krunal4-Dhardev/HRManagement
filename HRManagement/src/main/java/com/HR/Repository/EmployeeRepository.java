package com.HR.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.HR.Bean.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>
{
	@Query("SELECT e from Employees e where e.email = :email")
	public Employee getEmployeeByEmail(@Param("email") String email);
}