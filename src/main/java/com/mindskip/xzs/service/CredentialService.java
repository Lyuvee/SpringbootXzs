package com.mindskip.xzs.service;

import com.github.pagehelper.PageInfo;
import com.mindskip.xzs.domain.Credential;
import com.mindskip.xzs.domain.other.KeyValue;
import com.mindskip.xzs.viewmodel.admin.credential.CredentialPageRequestVM;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public interface CredentialService extends BaseService<Credential>{


    List<Credential> selectAll();

    Credential getCredentialById(Integer id);

    Credential getCredentialByName(String name);

    List<Credential> credentialPageList(String name, Integer pageIndex, Integer pageSize);

    PageInfo<Credential> credentialPage(CredentialPageRequestVM requestVM);

    void deleteCredentialById (Integer id);

    void insertCredential(Credential credential);

    void updateCredential(Credential credential);

    Integer selectAllCount();

    List<KeyValue> selectByCredentialName(String name);

    List<Credential> selectByIds(List<Integer> ids);

}

