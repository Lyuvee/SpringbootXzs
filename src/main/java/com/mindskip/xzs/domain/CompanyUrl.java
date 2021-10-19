package com.mindskip.xzs.domain;

public class CompanyUrl {
    private Integer id;
    private Integer companyId;
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "CompanyUrl{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", url='" + url + '\'' +
                '}';
    }
}
