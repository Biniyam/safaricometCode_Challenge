package com.example.demo.dao;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeEmployeeDataAccessService implements EmployeeDao {
    // Employee Fake data access service to store employees data in memory data structures List as storage
    private static List<Employee> DB = new ArrayList<>();

    @Override
    public int insertEmployee(String id, Employee employee) {
        DB.add(new Employee(id, employee.getName(), employee.getTitle(), employee.getDepartment()));
        return 1;
    }

    @Override
    public List<Employee> selectAllEmployee() {
        // returns all employee list
        return DB;
    }

    @Override
    public Optional<Employee> selectEmployeeById(String id) {
        // fetch employee data by id
        return DB.stream().filter(employee -> employee.getId().equals((id))).findFirst();
    }

    @Override
    public int deleteEmployeeById(String id) {
        // delete an employee
        // fetch employee by id and delete the record on the storage
        Optional<Employee> employee = selectEmployeeById(id);
        if (employee.isEmpty()) {
            return 0;
        }
        DB.remove(employee.get());
        return 1;
    }

    @Override
    public int updateEmployeeById(String id, Employee employee) {
        // update an employee by id, and employee object
        // fetch the employee from storage by given id and update the employee record on the storage
        return selectEmployeeById(id).map(e -> {
            int indexOfEmployee = DB.indexOf(e);
            if (indexOfEmployee >= 0) {
                DB.set(indexOfEmployee, employee);
                return 1;
            } else {
                return 0;
            }
        }).orElse(0);
    }
}
