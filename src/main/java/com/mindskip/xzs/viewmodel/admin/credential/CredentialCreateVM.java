package com.mindskip.xzs.viewmodel.admin.credential;


import javax.validation.constraints.NotBlank;

public class CredentialCreateVM {

    private Integer id;
    @NotBlank
    private String name;
    private String url;
    private Double weight;


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
}
