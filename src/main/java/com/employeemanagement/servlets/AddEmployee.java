package com.employeemanagement.servlets;

import com.connectorfactory.emp.ConnectionFactory;
import com.empdao.emp.EmployeeDaoImplementation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/addemp")
public class AddEmployee extends HttpServlet {
    public Connection con;
    public PreparedStatement pstmt;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/employee_form.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String emp_name = req.getParameter("name");
        String emp_designation = req.getParameter("designation");
        int emp_salary = Integer.parseInt(req.getParameter("salary"));
        String emp_password = req.getParameter("password");
        con = ConnectionFactory.buildConnection();
        EmployeeDaoImplementation emp_new_form_obj = new EmployeeDaoImplementation();
        int rows_impacted = emp_new_form_obj.insertEmployee(emp_name, emp_designation, emp_salary, emp_password, req, resp);
        System.out.println("total rows impacted" + rows_impacted);

    }
}
