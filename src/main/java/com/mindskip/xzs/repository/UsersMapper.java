package com.mindskip.xzs.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper {
    Integer getCompanyIdByName(String name);
}
