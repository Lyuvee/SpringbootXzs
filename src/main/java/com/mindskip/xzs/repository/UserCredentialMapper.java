package com.mindskip.xzs.repository;

import com.mindskip.xzs.domain.UserCredential;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserCredentialMapper extends BaseMapper<UserCredential>{

    List<UserCredential> getUserCredentialByUserId(Integer id);
    List<UserCredential> listCredential (Integer id);


}
