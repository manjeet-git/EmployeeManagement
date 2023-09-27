package com.software.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.employee.entity.Employee;
import com.software.employee.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("api/v1/employees")
public class employeeController {
	
	@Autowired
	EmployeeServiceImpl serviceImpl;
	
	
	@GetMapping(produces =MediaType.APPLICATION_JSON_VALUE, path = "/all-employees")
	public ResponseEntity<List<Employee>> getEmpoyeeDetails(){
		return new ResponseEntity<List<Employee>>(serviceImpl.presentingEmpRecords(), HttpStatus.FOUND);
		
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path="/employee-by-id/{id}")
	public  ResponseEntity<Employee> getEmployeeById(@PathVariable(name="id") int id) {
		return new ResponseEntity<Employee>(serviceImpl.getEmployeeById(id),HttpStatus.FOUND);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path="/show-by-bankname-balance/{bankname}/{balance}")
	public ResponseEntity<List<Employee>> getEmployeeByBankNameAndBalance(@PathVariable(name="bankname") String bankName, @PathVariable(name="balance") Long balance){
	return	new ResponseEntity<List<Employee>>(serviceImpl.showEmployeeHavingBankNameAndBalance(bankName,balance),HttpStatus.FOUND);
	}
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, path="/store-emp-details")
	public ResponseEntity<Employee> storeEmployeeDetails(@RequestBody Employee employee){
	return new ResponseEntity<Employee>(serviceImpl.persistEmployeeDetails(employee),HttpStatus.CREATED);	
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, path="/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(serviceImpl.modifyEmployeeDetails(employee),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public  void deleteEmployeeById(@PathVariable(name="id") int id) {
		serviceImpl.removeEmployeeById(id);
	}

}
