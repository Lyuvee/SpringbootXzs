package com.mindskip.xzs.service.impl;

import com.mindskip.xzs.domain.UserCredential;
import com.mindskip.xzs.repository.UserCredentialMapper;
import com.mindskip.xzs.service.UserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserCredentialServiceImpl extends BaseServiceImpl<UserCredential> implements UserCredentialService {
    private static final String CACHE_NAME = "xzs:t_user_credential";
    @Resource
    private final UserCredentialMapper userCredentialMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public UserCredentialServiceImpl(UserCredentialMapper userCredentialMapper, ApplicationEventPublisher eventPublisher) {
        super(userCredentialMapper);
        this.userCredentialMapper = userCredentialMapper;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void insertUserCredential(UserCredential userCredential) {
        userCredentialMapper.insertSelective(userCredential);

    }

    @Override
    @CacheEvict(value = CACHE_NAME, key = "#record.examPaperName")
    public int insertByFilter(UserCredential record) {
        return super.insertByFilter(record);
    }


    @Override
    @CacheEvict(value = CACHE_NAME, key = "#record.examPaperName")
    public int updateByIdFilter(UserCredential record) {
        return super.updateByIdFilter(record);
    }


    @Override
    public List<UserCredential> getUserCredentialByUserId(Integer id) {
        return null;
    }


    @Override
    public List<UserCredential> listCredential(Integer id) {
        return userCredentialMapper.listCredential(id);
    }


}
