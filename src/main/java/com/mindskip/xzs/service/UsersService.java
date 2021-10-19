package com.mindskip.xzs.service;


import org.springframework.stereotype.Service;

@Service

public interface UsersService {
    Integer getCompanyIdByName(String name);
}
