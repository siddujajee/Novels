package com.novelmanagement.servlets;

import com.connectorfactory.emp.ConnectionFactory;
import com.noveldao.novel.Novel;
import com.noveldao.novel.NovelDaoImplementation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet("/all_novel_list")
public class LoadAllNovels extends HttpServlet {
    Connection con = null;
    PreparedStatement loginStatement = null;
    ResultSet loginRecord = null;
    public void init() throws ServletException {
        con = ConnectionFactory.buildConnection();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            displayAllNovels(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            displayAllNovels(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayAllNovels(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        NovelDaoImplementation empDao = new NovelDaoImplementation();
        ArrayList<Novel> allNovelList = empDao.getAllNovelList();
        HttpSession session = req.getSession();

        req.setAttribute("novels", allNovelList);
        req.setAttribute("session_user", session.getAttribute("session_user"));
        req.getRequestDispatcher("novels/allnovels.jsp").forward(req, resp);
        req.setAttribute("session", session);
//        PrintWriter empWritter = resp.getWriter();
//        resp.setContentType("text/html");
//
//        for(Novel e: allNovelList){
//            empWritter.println("<div style='border-bottom:1px solid black'>" +
//                    "<div style='display:flex; align-items:center; gap:20px'>" +
//                        "<h3 style='font-weight: bold'>Title: </h3>" +
//                        "<p>" + e.getNovel_title() + "</p>" +
//                    "</div>" +
//                    "<div style='display:flex; align-items:center; gap:20px'>" +
//                        "<h3 style='font-weight: bold'>Content: </h3>" +
//                        "<p>" + e.getNovel_content() + "</p>" +
//                    "</div>" +
//                    "</div>");
//        }
//        empWritter.println("<a href='addnovel'>Add Novel</a>");
    }
}
