package com.mindskip.xzs.domain.task;


import java.io.Serializable;
import java.util.Date;

public class CredentialEventLog implements Serializable {

    public CredentialEventLog() {

    }

    public CredentialEventLog(Integer credentialId, String credentialName, Date createTime) {
        this.credentialId = credentialId;
        this.credentialName = credentialName;
        this.createTime = createTime;
    }

    private Integer id;

    private Integer credentialId;

    private String credentialName;

    private String content;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Integer credentialId) {
        this.credentialId = credentialId;
    }

    public String getCredentialName() {
        return credentialName;
    }

    public void setCredentialName(String credentialName) {
        this.credentialName = credentialName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
