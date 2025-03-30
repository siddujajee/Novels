package com.novelmanagement.servlets;

import com.connectorfactory.emp.ConnectionFactory;
import com.empdao.emp.EmployeeDaoImplementation;
import com.noveldao.novel.NovelDaoImplementation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/addnovel")
public class AddNovel extends HttpServlet {
    public Connection con = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("novels/novel_form.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String novel_title = req.getParameter("novel_title");
        String novel_content = req.getParameter("novel_content");
        con = ConnectionFactory.buildConnection();
        NovelDaoImplementation novel_new_form_obj = new NovelDaoImplementation();
        int rows_impacted = novel_new_form_obj.insertNovel(novel_title, novel_content, req, resp);
        System.out.println("total rows impacted" + rows_impacted);

    }
}
