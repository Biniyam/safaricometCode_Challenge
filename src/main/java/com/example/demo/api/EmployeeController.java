package com.example.demo.api;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping
    public int addEmployee(@RequestBody Employee employee) {
        // Create an employee
        return employeeService.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployee() {
        // Get list of all employees
        return employeeService.getAllEmployee();
    }
    @GetMapping(path = "{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        // Get an employee by id
        return employeeService.getEmployeeById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public int deleteEmployee(@PathVariable String id) {
        // Delete an employee by id
        return employeeService.deleteEmployee((id));
    }

    @PutMapping(path = "{id}")
    public int updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }
}
