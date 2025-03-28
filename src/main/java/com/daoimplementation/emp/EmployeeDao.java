package com.daoimplementation.emp;
import com.empdao.emp.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;

public interface EmployeeDao {
    ArrayList<Employee> getAllEmpList();
    boolean isEmpExist(String emp_name, String emp_password, HttpServletRequest req, HttpServletResponse resp);
    int insertEmployee(String emp_name, String emp_designation, int emp_salary, String emp_password, HttpServletRequest req, HttpServletResponse resp);
    boolean updateEmployee(Employee emp);
    boolean deleteEmployee(int id);
}
