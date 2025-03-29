package com.empdao.emp;

import com.connectorfactory.emp.ConnectionFactory;
import com.daoimplementation.emp.EmployeeDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class EmployeeDaoImplementation implements EmployeeDao {
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ArrayList<Employee> allEmpList = new ArrayList<Employee>();
    Connection con = ConnectionFactory.buildConnection();
    @Override
    public ArrayList<Employee> getAllEmpList() {
        try {
            stmt = con.createStatement();
            ResultSet empList = stmt.executeQuery("select * from employee_table");
            while(empList.next()){
                String empName = empList.getString(2);
                String empDesignation = empList.getString(4);
                int empSalary = empList.getInt(5);
                Employee e = new Employee(empName, empDesignation, empSalary);
                System.out.println(e);
                allEmpList.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEmpList;
    }

    @Override
    public Employee getEmployee(String emp_name, String emp_password, HttpServletRequest req, HttpServletResponse resp) {
        String loginQuery = "select * from employee_table where name = ? and password = ?";
        PreparedStatement loginStatement = null;
        ResultSet loginRecord = null;
        try {
            loginStatement = con.prepareStatement(loginQuery);
            loginStatement.setString(1, emp_name);
            loginStatement.setString(2, emp_password);
            loginRecord = loginStatement.executeQuery();
            if(loginRecord.next()){
                Employee e = new Employee(emp_name, loginRecord.getString(4), loginRecord.getInt(5));
                return e;
            }else{
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insertEmployee(String emp_name, String emp_designation, int emp_salary, String emp_password, HttpServletRequest req, HttpServletResponse resp) {
        int rows_impacted = 0;
        try {
            pstmt = con.prepareStatement("insert into employee_table (`name`, `password`, `designation`, `salary`) values (?, ?, ?, ?)");
            pstmt.setString(1, emp_name);
            pstmt.setString(2, emp_password);
            pstmt.setString(3, emp_designation);
            pstmt.setInt(4, emp_salary);
            rows_impacted = pstmt.executeUpdate();
            System.out.println(rows_impacted);

            PrintWriter emp_added_writer = resp.getWriter();
            resp.setContentType("text/html");
            emp_added_writer.println("<h3>" + emp_name + " is added to employee table </h3>");
            emp_added_writer.println("<a href='all_emp_list' style='padding: 5px; text-decoration: none; background: blue; color: white;'>Ok</a>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows_impacted;
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
