package com.example.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.database.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
