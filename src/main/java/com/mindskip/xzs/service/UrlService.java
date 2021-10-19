package com.mindskip.xzs.service;


import org.springframework.stereotype.Service;

@Service
public interface UrlService {
    String getUrlByCompanyId(Integer CompanyId);
}
