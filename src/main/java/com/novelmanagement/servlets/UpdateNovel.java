package com.novelmanagement.servlets;

import com.noveldao.novel.Novel;
import com.noveldao.novel.NovelDaoImplementation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/updateNovel")
public class UpdateNovel extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Novel novel = new Novel(Integer.parseInt(req.getParameter("novel_id")), req.getParameter("novel_title"), req.getParameter("novel_content"));

        NovelDaoImplementation update = new NovelDaoImplementation();
        Novel updatedNovel = update.updateNovel(novel);
        if(updatedNovel != null){
            req.setAttribute("updatedNovel", updatedNovel);
            req.getRequestDispatcher("all_novel_list").forward(req, resp);
        }
    }
}
