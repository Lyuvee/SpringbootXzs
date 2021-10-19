package com.mindskip.xzs.service.impl;

import com.mindskip.xzs.repository.UrlMapper;
import com.mindskip.xzs.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UrlServiceImpl implements UrlService {

    private final UrlMapper urlMapper;

    @Autowired
    public UrlServiceImpl(UrlMapper urlMapper) {
        this.urlMapper = urlMapper;
    }

    @Override
    public String getUrlByCompanyId(Integer CompanyId) {
        return urlMapper.getUrlByCompanyId(CompanyId);
    }
}
