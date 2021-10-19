package com.mindskip.xzs.service.impl;

import com.mindskip.xzs.repository.UsersMapper;
import com.mindskip.xzs.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    private final UsersMapper usersMapper;

    @Autowired
    public UsersServiceImpl(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public Integer getCompanyIdByName(String name){
        return usersMapper.getCompanyIdByName(name);
    }

}
