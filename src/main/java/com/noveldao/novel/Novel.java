package com.noveldao.novel;

public class Novel {
    private int novel_id;
    private String novel_title;
    private String novel_content;

    public Novel(int novel_id, String novel_title, String novel_content) {
        this.novel_id = novel_id;
        this.novel_title = novel_title;
        this.novel_content = novel_content;
    }

    public String getNovel_content() {
        return novel_content;
    }

    public void setNovel_content(String novel_content) {
        this.novel_content = novel_content;
    }

    public String getNovel_title() {
        return novel_title;
    }

    public void setNovel_title(String novel_title) {
        this.novel_title = novel_title;
    }

    public int getNovel_id() {
        return novel_id;
    }

    public void setNovel_id(int novel_id) {
        this.novel_id = novel_id;
    }
}
