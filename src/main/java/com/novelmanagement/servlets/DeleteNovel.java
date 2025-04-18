package com.novelmanagement.servlets;

import com.noveldao.novel.NovelDaoImplementation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete_novel")
public class DeleteNovel extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("deletion of novel in progress");
        NovelDaoImplementation delete_novel = new NovelDaoImplementation();
        boolean is_deleted = delete_novel.deleteNovel(Integer.parseInt(req.getParameter("id")));
    }
}
