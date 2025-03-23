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
    PreparedStatement loginStatement = null;
    ResultSet loginRecord = null;
    @Override
    public void init() throws ServletException {
        con = ConnectionFactory.buildConnection();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("user_name");
        String password = req.getParameter("password");
        String loginQuery = "select * from employee_table where name = ? and password = ?";
        try {
            loginStatement = con.prepareStatement(loginQuery);
            loginStatement.setString(1, userName);
            loginStatement.setString(2,password);
            loginRecord = loginStatement.executeQuery();
            if(loginRecord.next()){
                req.getRequestDispatcher("/all_emp_list").forward(req, resp);
            }else{
                RequestDispatcher invalidCredentials = req.getRequestDispatcher("/invalidlogin.html");
                invalidCredentials.forward(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
