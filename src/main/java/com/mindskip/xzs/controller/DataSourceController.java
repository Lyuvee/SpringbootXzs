//package com.mindskip.xzs.controller;
//
//import com.mindskip.xzs.DataSource.DynamicDataSourceContextHolder;
//import com.mindskip.xzs.base.BaseApiController;
//import com.mindskip.xzs.base.RestResponse;
//import com.mindskip.xzs.domain.Subject;
//import com.mindskip.xzs.domain.User;
//import com.mindskip.xzs.service.SubjectService;
//import com.mindskip.xzs.service.UrlService;
//import com.mindskip.xzs.service.UserService;
//import com.mindskip.xzs.service.UsersService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//
//@RestController
//@RequestMapping("/datasources")
//@Api(tags = "添加删除数据源")
//public class DataSourceController extends BaseApiController {
//
//
//    private final UserService userService;
//    private final UsersService usersService;
//    private final UrlService urlService;
//    private final SubjectService subjectService;
//
//
//
//    public DataSourceController(UserService userService, UsersService usersService, UrlService urlService, SubjectService subjectService) {
//        this.userService = userService;
//        this.usersService = usersService;
//        this.urlService = urlService;
//        this.subjectService = subjectService;
//
//    }
//
//
//    @RequestMapping(value="/salve")
//    @ApiOperation("切换")
//    public RestResponse<List<Subject>> salve(){
//        User user = getCurrentUser();
//        String key;
//        int i = usersService.getCompanyIdByName(user.getUserName());
//        if (i == 2){
//            key ="slave";
//        }
//        else {key = "master";}
//
//        DynamicDataSourceContextHolder.setDataSourceKey(key);
//        List<Subject> subjects = subjectService.allSubject();
//        return RestResponse.ok(subjects);
//
//    }
//    @RequestMapping(value="/master")
//    @ApiOperation("查看当前")
//    public RestResponse<List<Subject>> master(){
//
//        //DynamicDataSourceContextHolder.setDataSourceKey("slave");
//        List<Subject> subjects = subjectService.allSubject();
//        return RestResponse.ok(subjects);
//
//    }
//
//}