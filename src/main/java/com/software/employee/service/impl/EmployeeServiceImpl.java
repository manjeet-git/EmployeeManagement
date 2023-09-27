package com.software.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.software.employee.entity.Employee;
import com.software.employee.exception.EmployeeNotFoundException;
import com.software.employee.repository.EmployeesRepository;

@Service
public class EmployeeServiceImpl {
	
	@Autowired
	EmployeesRepository repository;
	
	public List<Employee> presentingEmpRecords(){
		return repository.findAll();
	}
	
	public Employee persistEmployeeDetails(Employee emp) {
		return repository.save(emp);
	}

	public List<Employee> showEmployeeHavingBankNameAndBalance(String bankName, Long balance) {
		// TODO Auto-generated method stub
		return repository.fetchEmployeeBybankNameAndBalance(bankName, balance);
	}

	public Employee modifyEmployeeDetails(Employee employee) {
		// TODO Auto-generated method stub
		return repository.save(employee);
	}

	public void removeEmployeeById(int id) {
		repository.deleteById(id);
		
	}

	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee=repository.findById(id);
		if(employee.isPresent())
			return employee.get();
		throw new EmployeeNotFoundException("Employee having id : "+id+" not found ");
	}

}
