package com.mindskip.xzs.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Credential implements Serializable {
    private Integer id;
    private String name;
    private String url;
    /**
     * 证书id 和 名字
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;

    private Double weight;

    /**
     * 创建日期
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Credential{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", date=" + date +
                ", weight=" + weight +
                '}';
    }
}
