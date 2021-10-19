package com.mindskip.xzs.repository;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UrlMapper {
    String getUrlByCompanyId(Integer CompanyId);
}
