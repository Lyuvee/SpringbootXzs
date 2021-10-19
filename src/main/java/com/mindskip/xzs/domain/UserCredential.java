package com.mindskip.xzs.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserCredential {
    private Integer id;
    private String examPaperName;
    private String url;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTime;
    private Integer userId;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExamPaperName() {
        return examPaperName;
    }

    public void setExamPaperName(String examPaperName) {
        this.examPaperName = examPaperName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserCredential{" +
                "id=" + id +
                ", examPaperName='" + examPaperName + '\'' +
                ", url='" + url + '\'' +
                ", createTime=" + createTime +
                ", userId=" + userId +
                '}';
    }
}
