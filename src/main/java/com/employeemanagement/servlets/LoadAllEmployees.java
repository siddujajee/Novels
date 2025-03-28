package com.employeemanagement.servlets;

import com.connectorfactory.emp.ConnectionFactory;
import com.empdao.emp.Employee;
import com.empdao.emp.EmployeeDaoImplementation;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

public class LoadAllEmployees extends HttpServlet {
    Connection con = null;
    public void init() throws ServletException {
        con = ConnectionFactory.buildConnection();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            displayAllEmployees(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            displayAllEmployees(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void displayAllEmployees(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        EmployeeDaoImplementation empDao = new EmployeeDaoImplementation();
        ArrayList<Employee> allEmpList = empDao.getAllEmpList();

        //until we learn about jsp we will write the data to the browser manually

        PrintWriter empWritter = resp.getWriter();
        resp.setContentType("text/html");
        empWritter.println("<table>" +
                "  <thead>" +
                "    <tr>" +
                "      <th>SI</th>" +
                "      <th>Name</th>" +
                "      <th>Designation</th>" +
                "      <th>salary</th>" +
                "    </tr>" +
                "  </thead>");

        for(Employee e: allEmpList){
            empWritter.println("<table>" +
                    "<tbody>" +
                    "    <tr>" +
                    "      <td>" + e.getId() + "</td>" +
                    "      <td>" + e.getName() + "</td>" +
                    "      <td>" + e.getDesignation() + "</td>" +
                    "      <td>" + e.getSalary() + "</td>" +
                    "    </tr>" +
                    "  </tbody>");
        }
        empWritter.println("</table>");
        empWritter.println("<a href='addemp'>Add employee</a>");
    }
}
