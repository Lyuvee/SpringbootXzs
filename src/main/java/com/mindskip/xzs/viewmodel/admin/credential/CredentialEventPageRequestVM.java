package com.mindskip.xzs.viewmodel.admin.credential;

import com.mindskip.xzs.base.BasePage;

public class CredentialEventPageRequestVM extends BasePage {

    private Integer credentialId;

    private Integer credentialName;

    public Integer getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Integer credentialId) {
        this.credentialId = credentialId;
    }

    public Integer getCredentialName() {
        return credentialName;
    }

    public void setCredentialName(Integer credentialName) {
        this.credentialName = credentialName;
    }
}
