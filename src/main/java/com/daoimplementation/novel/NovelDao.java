package com.daoimplementation.novel;


import com.noveldao.novel.Novel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;

public interface NovelDao {
    ArrayList<Novel> getAllNovelList();
    int insertNovel(String novel_title, String novel_content, HttpServletRequest req, HttpServletResponse resp);
    boolean updateNovel(Novel novel);
    boolean deleteNovel(int id);
}
