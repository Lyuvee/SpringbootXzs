package com.mindskip.xzs.controller.admin;

import com.github.pagehelper.PageInfo;
import com.mindskip.xzs.base.BaseApiController;
import com.mindskip.xzs.base.RestResponse;
import com.mindskip.xzs.domain.other.KeyValue;
import com.mindskip.xzs.service.AuthenticationService;
import com.mindskip.xzs.service.CredentialService;
import com.mindskip.xzs.utility.PageInfoHelper;
import com.mindskip.xzs.viewmodel.admin.credential.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mindskip.xzs.domain.Credential;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController("AdminCredentialController")
@RequestMapping(value = "api/admin/credential")
public class CredentialController extends BaseApiController {


    private final CredentialService credentialService;
//    private final CredentialEventLogService credentialEventLogService;
    private final AuthenticationService authenticationService;

    @Autowired
    public CredentialController(CredentialService credentialService, AuthenticationService authenticationService) {
        this.credentialService = credentialService;
//        this.credentialEventLogService = credentialEventLogService;
        this.authenticationService = authenticationService;
    }



    //打印所有证书信息
    @RequestMapping(value ="/selectAll")
    @ResponseBody
    public RestResponse<List<Credential>> ListCredential() {
        return RestResponse.ok(credentialService.selectAll());
    }



    @RequestMapping(value = "/page/list", method = RequestMethod.POST)
    public RestResponse<PageInfo<CredentialResponseVM>> pageList(@RequestBody CredentialPageRequestVM model) {
        PageInfo<Credential> pageInfo = credentialService.credentialPage(model);
        PageInfo<CredentialResponseVM> page = PageInfoHelper.copyMap(pageInfo, d -> CredentialResponseVM.from(d));
        return RestResponse.ok(page);
    }

//    @RequestMapping(value = "/event/page/list", method = RequestMethod.POST)
//    public RestResponse<PageInfo<CredentialEventLogVM>> eventPageList(@RequestBody CredentialEventPageRequestVM model) {
//        PageInfo<CredentialEventLog> pageInfo = credentialEventLogService.page(model);
//        PageInfo<CredentialEventLogVM> page = PageInfoHelper.copyMap(pageInfo, d -> {
//            CredentialEventLogVM vm = modelMapper.map(d, CredentialEventLogVM.class);
//            vm.setCreateTime(DateTimeUtil.dateFormat(d.getCreateTime()));
//            return vm;
//        });
//        return RestResponse.ok(page);
//    }

    @RequestMapping(value = "/select/{id}", method = RequestMethod.POST)
    public RestResponse<CredentialResponseVM> select(@PathVariable Integer id) {
        Credential credential = credentialService.getCredentialById(id);
        CredentialResponseVM credentialVm = CredentialResponseVM.from(credential);
        return RestResponse.ok(credentialVm);
    }

    @RequestMapping(value = "/current", method = RequestMethod.POST)
    public RestResponse<CredentialResponseVM> current() {
        Credential credential = getCurrentCredential();
        CredentialResponseVM credentialVm = CredentialResponseVM.from(credential);
        return RestResponse.ok(credentialVm);
    }



    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public RestResponse<Credential> edit(@RequestBody @Valid CredentialCreateVM model) {
        if (model.getId() == null) {  //create
            Credential existCredential = credentialService.getCredentialByName(model.getName());
            if (null != existCredential) {
                return new RestResponse<>(2, "证书名称重复");
            }
        }
        Credential credential = modelMapper.map(model, Credential.class);

        if (model.getId() == null) {
            credential.setDate(new Date());
            credentialService.insertByFilter(credential);
        }
        else {
            credential.setDate(new Date());
            credentialService.updateByIdFilter(credential);
        }
        return RestResponse.ok(credential);

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public RestResponse update(@RequestBody @Valid CredentialUpdateVM model) {
        Credential credential = credentialService.selectById(getCurrentCredential().getId());
        modelMapper.map(model, credential);
        credential.setDate(new Date());
        credentialService.updateByIdFilter(credential);
        return RestResponse.ok();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public RestResponse delete(@PathVariable Integer id) {

        credentialService.deleteCredentialById(id);
        return RestResponse.ok();
    }

    @RequestMapping(value = "/selectByCredentialName", method = RequestMethod.POST)
    public RestResponse<List<KeyValue>> selectByCredentialName(@RequestBody String name) {
        List<KeyValue> keyValues = credentialService.selectByCredentialName(name);
        return RestResponse.ok(keyValues);
    }

    @RequestMapping(value ="/getNames", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    @ResponseBody
    public RestResponse<List<Credential>> getNames() {
        List<Credential> credentials = credentialService.selectAll();
        return RestResponse.ok(credentials);
    }



}
