package com.mindskip.xzs.repository;

import com.mindskip.xzs.domain.Credential;
import com.mindskip.xzs.domain.other.KeyValue;
import com.mindskip.xzs.viewmodel.admin.credential.CredentialPageRequestVM;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;


/**
 * @author Liang
 */
@Mapper
public interface CredentialMapper extends BaseMapper<Credential>{



    List<Credential> getNames();
    /**
     * 查询证书所有信息
     */
    List<Credential> selectAll ();

    Credential getCredentialById(Integer id);

    Credential getCredentialByName(String name);

    List<Credential> credentialPageList (Map<String, Object> map);

    List<Credential> credentialPage(CredentialPageRequestVM requestVM);

    void deleteCredentialById (Integer id);

    Void insertCredential (Credential credential);

    Void updateCredential (Credential credential);

    Integer selectAllCount();

    List<KeyValue> selectByCredentialName(String name);

    List<Credential> selectByIds(List<Integer> ids);






}
