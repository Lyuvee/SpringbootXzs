package com.mindskip.xzs.service;

import com.github.pagehelper.PageInfo;
import com.mindskip.xzs.domain.UserEventLog;
import com.mindskip.xzs.domain.task.CredentialEventLog;
import com.mindskip.xzs.viewmodel.admin.credential.CredentialEventPageRequestVM;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CredentialEventLogService extends BaseService<UserEventLog> {

    List<CredentialEventLog> getCredentialEventLogByUserId(Integer id);

    PageInfo<CredentialEventLog> page(CredentialEventPageRequestVM requestVM);

    List<Integer> selectMothCount();
}
