package com.mindskip.xzs.viewmodel.admin.credential;

import com.mindskip.xzs.base.BasePage;

public class CredentialPageRequestVM extends BasePage {
    private String name;
    private Integer role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
