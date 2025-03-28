package com.employeemanagement.servlets;
import com.connectorfactory.emp.ConnectionFactory;
import com.empdao.emp.Employee;
import com.empdao.emp.EmployeeDaoImplementation;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class EmployeeLogin extends HttpServlet{
    Connection con = null;
    @Override
    public void init() throws ServletException {
        con = ConnectionFactory.buildConnection();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("user_name");
        String password = req.getParameter("password");
        EmployeeDaoImplementation checking_emp_obj = new EmployeeDaoImplementation();
        if(checking_emp_obj.isEmpExist(userName, password, req, resp)){
            req.getRequestDispatcher("/all_novel_list").forward(req, resp);
        }else{
            RequestDispatcher invalidCredentials = req.getRequestDispatcher("/invalidlogin.html");
            invalidCredentials.forward(req, resp);
        }
    }
}
