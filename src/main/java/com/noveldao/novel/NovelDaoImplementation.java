package com.noveldao.novel;

import com.connectorfactory.emp.ConnectionFactory;
import com.daoimplementation.novel.NovelDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class NovelDaoImplementation implements NovelDao {
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ArrayList<Novel> allNovelList = new ArrayList<Novel>();
    Connection con = ConnectionFactory.buildConnection();
    @Override
    public ArrayList<Novel> getAllNovelList() {
        try {
            stmt = con.createStatement();
            ResultSet novelList = stmt.executeQuery("select * from novel_table");
            while(novelList.next()){
                int novelId = novelList.getInt(1);
                String novelTitle = novelList.getString(2);
                String novelContent = novelList.getString(3);
                Novel e = new Novel(novelId, novelTitle, novelContent);
                System.out.println(e);
                allNovelList.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allNovelList;
    }

    @Override
    public int insertNovel(String novel_title, String novel_content, HttpServletRequest req, HttpServletResponse resp) {
        int rows_impacted = 0;
        try {
            pstmt = con.prepareStatement("insert into novel_table (`novel_title`, `novel_content`) values (?, ?)");
            pstmt.setString(1, novel_title);
            pstmt.setString(2, novel_content);
            rows_impacted = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows_impacted;
    }

    @Override
    public Novel updateNovel(Novel novel) {
        int rows_impacted = 0;
        try {
            pstmt = con.prepareStatement("update novel_table set novel_title = ?, novel_content = ? where novel_id = ?");
            pstmt.setString(1, novel.getNovel_title());
            pstmt.setString(2, novel.getNovel_content());
            pstmt.setInt(3, novel.getNovel_id());

            rows_impacted = pstmt.executeUpdate();
            System.out.println(rows_impacted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return novel;
    }

    @Override
    public boolean deleteNovel(int id) {
        try{
            pstmt = con.prepareStatement("delete from novel_table where novel_id = ?");
            pstmt.setInt(1, id);
            int total_deleted_rows = pstmt.executeUpdate();
            if(total_deleted_rows > 0){
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
