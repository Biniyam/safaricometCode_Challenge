package com.example.demo.dao;

import com.example.demo.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeDao {
    int insertEmployee(String id, Employee employee);

    List<Employee> selectAllEmployee();

    Optional<Employee> selectEmployeeById(String id);

    int deleteEmployeeById(String id);
    int updateEmployeeById(String id, Employee employee);
}