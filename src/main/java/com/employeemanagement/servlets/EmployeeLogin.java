package com.employeemanagement.servlets;
import com.connectorfactory.emp.ConnectionFactory;
import com.empdao.emp.Employee;
import com.empdao.emp.EmployeeDaoImplementation;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet("/login")
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
        Employee loggedInEmployee = checking_emp_obj.getEmployee(userName, password, req, resp);
        if(loggedInEmployee != null){
            HttpSession session = req.getSession();
            session.setAttribute("session_user", loggedInEmployee);
            resp.sendRedirect("all_novel_list");
        }else{
            RequestDispatcher invalidCredentials = req.getRequestDispatcher("/invalidlogin.html");
            invalidCredentials.forward(req, resp);
        }
    }
}
