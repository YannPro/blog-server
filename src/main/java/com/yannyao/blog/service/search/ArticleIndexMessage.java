package com.yannyao.blog.service.search;

public class ArticleIndexMessage {
    public static final String INDEX = "index";

    public static final String REMOVE = "remove";

    public static final Integer MAX_RETRY = 3;

    private Integer articleId;

    private String operation;

    private Integer retry = 0;

    /**
     * 默认构造器 防止jackson序列失败
     */
    public ArticleIndexMessage() {
    }

    public ArticleIndexMessage(Integer articleId, String operation, Integer retry) {
        this.articleId = articleId;
        this.operation = operation;
        this.retry = retry;
    }

    public Integer getInfoId() {
        return articleId;
    }

    public void setInfoId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer getRetry() {
        return retry;
    }

    public void setRetry(Integer retry) {
        this.retry = retry;
    }
}
