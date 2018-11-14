package com.yannyao.blog.common.enums;

public enum CommentType {

    /*0为文章评论  1为留言*/
    ARTICLE_COMMENT(0), MSG_COMMENT(1);

    private int type;

    CommentType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
