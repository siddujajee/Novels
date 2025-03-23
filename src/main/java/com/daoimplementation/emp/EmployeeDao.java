package com.daoimplementation.emp;
import com.empdao.emp.*;

import java.util.ArrayList;

public interface EmployeeDao {
    ArrayList<Employee> getAllEmpList();
    Employee getEmpInfo(int id);
    boolean insetEmployee(int id, String name, String designation, int Salary);
    boolean updateEmployee(Employee emp);
    boolean deleteEmployee(int id);
}
