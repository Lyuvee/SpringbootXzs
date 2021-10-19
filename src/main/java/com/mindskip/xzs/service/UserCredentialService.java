package com.mindskip.xzs.service;

import com.mindskip.xzs.domain.UserCredential;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserCredentialService extends BaseService<UserCredential>{

    void insertUserCredential (UserCredential userCredential);
    List<UserCredential> getUserCredentialByUserId(Integer id);
    List<UserCredential> listCredential (Integer id);

}
