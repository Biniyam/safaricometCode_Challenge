package com.example.demo.service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(@Qualifier("fakeDao") EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    public int addEmployee(Employee employee) {
        return employeeDao.insertEmployee(employee.getId(), employee);
    }

    public List<Employee> getAllEmployee() {
        return employeeDao.selectAllEmployee();
    }
    public Optional<Employee> getEmployeeById(String id) {
        return employeeDao.selectEmployeeById(id);
    }

    public int deleteEmployee(String id) {
        return employeeDao.deleteEmployeeById(id);
    }
    public int updateEmployee(String id, Employee employee) {
        return employeeDao.updateEmployeeById(id, employee);
    }
}
