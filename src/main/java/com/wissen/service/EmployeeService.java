package com.wissen.service;

import com.wissen.entity.Employee;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

public interface EmployeeService {
    String createEmployee(Employee employee);
    String createEmployeeFromExcel(MultipartFile file)  throws IOException;
    List<Employee> readEmployee();
    Employee readEmployee(int id);
    List<Employee> readEmployee(boolean active);
    String updateEmployee(Employee employee, int id);
    String deleteEmployee(int id);
}
