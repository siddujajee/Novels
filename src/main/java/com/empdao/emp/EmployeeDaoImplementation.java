package com.empdao.emp;

import com.connectorfactory.emp.ConnectionFactory;
import com.daoimplementation.emp.EmployeeDao;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDaoImplementation implements EmployeeDao {
    Statement stmt = null;
    ArrayList<Employee> allEmpList = new ArrayList<Employee>();
    @Override
    public ArrayList<Employee> getAllEmpList() {
        Connection con = ConnectionFactory.buildConnection();
        try {
            stmt = con.createStatement();
            ResultSet empList = stmt.executeQuery("select * from employee_table");
            while(empList.next()){
                int empId = empList.getInt(1);
                String empName = empList.getString(2);
                String empDesignation = empList.getString(4);
                int empSalary = empList.getInt(5);
                Employee e = new Employee(empId, empName, empDesignation, empSalary);
                System.out.println(e);
                allEmpList.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEmpList;
    }

    @Override
    public Employee getEmpInfo(int id) {
        return null;
    }

    @Override
    public boolean insetEmployee(int id, String name, String designation, int Salary) {
        return false;
    }

    @Override
    public boolean updateEmployee(Employee emp) {
        return false;
    }

    @Override
    public boolean deleteEmployee(int id) {
        return false;
    }
}
