package com.mindskip.xzs.viewmodel.admin.credential;

import com.mindskip.xzs.domain.Credential;
import com.mindskip.xzs.utility.DateTimeUtil;
import com.mindskip.xzs.viewmodel.BaseVM;

public class CredentialResponseVM extends BaseVM {

    private Integer id;
    private String name;
    private String url;
    private String date;
    private Double weight;

    public static CredentialResponseVM from(Credential credential) {
        CredentialResponseVM vm = modelMapper.map(credential, CredentialResponseVM.class);
        vm.setDate(DateTimeUtil.dateFormat(credential.getDate()));

        return vm;
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
