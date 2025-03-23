package com.employeemanagement.servlets;

import com.connectorfactory.emp.ConnectionFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        try {
            System.out.println("inside add employee servle");
            pstmt = con.prepareStatement("insert into employee_table (`name`, `password`, `designation`, `salary`) values (?, ?, ?, ?)");
            pstmt.setString(1, emp_name);
            pstmt.setString(2, emp_password);
            pstmt.setString(3, emp_designation);
            pstmt.setInt(4, emp_salary);
            int rows_impacted = pstmt.executeUpdate();
            System.out.println(rows_impacted);

            PrintWriter emp_added_writer = resp.getWriter();
            resp.setContentType("text/html");
            emp_added_writer.println("<h3>" + emp_name + " is added to employee table </h3>");
            emp_added_writer.println("<a href='all_emp_list' style='padding: 5px; text-decoration: none; background: blue; color: white;'>Ok</a>");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
