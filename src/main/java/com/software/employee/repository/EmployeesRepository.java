package com.software.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.software.employee.entity.Employee;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "select e from Employee e JOIN e.bankAccounts b where b.bankName= :bankName and b.balance > :balance")
	public List<Employee> fetchEmployeeBybankNameAndBalance(@Param(value = "bankName") String bankName, @Param(value = "balance") Long balance);
}
