package com.example.database.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.entity.Employee;
import com.example.database.repository.AddressRepository;
import com.example.database.repository.EmployeeRepository;

@Service

public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private AddressRepository addressRepo;

	public boolean saveEmployee(Employee emp) {
		try {
			addressRepo.save(emp.getAddress());
			empRepo.save(emp);
			empRepo.flush();
			return true;
		} catch (Exception e) {
			System.out.print("Save Emp error: " + e.getMessage());
			return false;
		}
	}
	
	public List<Employee> list(){
		
		return empRepo.findAll();
		
	}
	
	public Optional<Employee> get(String eid){
		return empRepo.findById(eid);
	}
	
	public boolean deleteEmployee(String eid) {
		try {
			empRepo.deleteById(eid);
			empRepo.flush();
			return true;
		} catch (Exception e) {
			System.out.print("Save Emp error: " + e.getMessage());
			return false;
		}
	}

}
