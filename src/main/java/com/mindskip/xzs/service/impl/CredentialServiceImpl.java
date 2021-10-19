package com.mindskip.xzs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mindskip.xzs.domain.Credential;
import com.mindskip.xzs.domain.other.KeyValue;
import com.mindskip.xzs.event.OnRegistrationCompleteEvent1;
import com.mindskip.xzs.repository.CredentialMapper;
import com.mindskip.xzs.service.CredentialService;
import com.mindskip.xzs.viewmodel.admin.credential.CredentialPageRequestVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CredentialServiceImpl extends BaseServiceImpl<Credential> implements CredentialService {
    private static final String CACHE_NAME = "xzs:credential";
    @Resource
    private CredentialMapper credentialMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public CredentialServiceImpl(CredentialMapper credentialMapper , ApplicationEventPublisher eventPublisher) {
        super(credentialMapper);
        this.credentialMapper =credentialMapper;
        this.eventPublisher = eventPublisher;
    }



//以下为全新

    @Override
    public List<Credential> selectAll() {
        return credentialMapper.selectAll();
    }

    @Override
    public Credential getCredentialById(Integer id) {
        return credentialMapper.getCredentialById(id);
    }

    @Override
    @Cacheable(value = CACHE_NAME, key = "#name", unless = "#result == null")
    public Credential getCredentialByName(String name) {
        return credentialMapper.getCredentialByName(name);
    }

    @Override
    @CacheEvict(value = CACHE_NAME, key = "#record.name")
    public int insertByFilter(Credential record) {
        return super.insertByFilter(record);
    }

    @Override
    @CacheEvict(value = CACHE_NAME, key = "#record.name")
    public int updateByIdFilter(Credential record) {
        return super.updateByIdFilter(record);
    }

    @Override
    @CacheEvict(value = CACHE_NAME, key = "#record.name")
    public int updateById(Credential record) {
        return super.updateById(record);
    }

    @Override
    public List<Credential> credentialPageList(String name, Integer pageIndex, Integer pageSize) {
        Map<String, Object> map = new HashMap<>(3);
        map.put("name", name);
        map.put("offset", ((int) pageIndex) * pageSize);
        map.put("limit", pageSize);
        return credentialMapper.credentialPageList(map);
    }

    @Override
    public PageInfo<Credential> credentialPage(CredentialPageRequestVM requestVM) {
        return PageHelper.startPage(requestVM.getPageIndex(), requestVM.getPageSize(), "id desc").doSelectPageInfo(() ->
                credentialMapper.credentialPage(requestVM)
        );
    }

    @Override
    public void deleteCredentialById(Integer id) {

        credentialMapper.deleteCredentialById(id);

    }

    @Override
    public void insertCredential(Credential credential) {
        credentialMapper.insertSelective(credential);
        eventPublisher.publishEvent(new OnRegistrationCompleteEvent1(credential));
    }

    @Override
    public void updateCredential(Credential credential) {
        credentialMapper.updateCredential(credential);
    }


    @Override
    public Integer selectAllCount() {
        return credentialMapper.selectAllCount();
    }

    @Override
    public List<KeyValue> selectByCredentialName(String name) {
        return credentialMapper.selectByCredentialName(name);
    }

    @Override
    public List<Credential> selectByIds(List<Integer> ids) {
        return credentialMapper.selectByIds(ids);
    }


}
