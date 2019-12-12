package com.xpl.web.controller;

import com.xpl.entity.constant.ErrorCodeConstant;
import com.xpl.entity.po.UserInfoPO;
import com.xpl.framework.ResultView;
import com.xpl.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;


    @GetMapping(value = "exclude")
    public ResultView<?> exclude(){
        ResultView<?> result = new ResultView<>();

        log.trace("trace日志打印");
        log.debug("debug日志打印");
        log.info("info日志打印");
        log.warn("warn日志打印");
        log.error("error日志打印");
        result.setCode(ErrorCodeConstant.CODE_SUCCESS);
        result.setMsg(ErrorCodeConstant.ERRORMSG_EXCEPTION);
        return result;
    }

    @GetMapping(value = "user/{id}")
    public ResultView<UserInfoPO> getUser(@PathVariable("id") int id) {
        ResultView<UserInfoPO> result = new ResultView<>();

        result.setCode(ErrorCodeConstant.CODE_SUCCESS);
        result.setData(userInfoService.getById(id));
        return result;
    }

    @Value("${spring.application.name}")
    private String appName;

    @Value("${spring.datasource.url}")
    private String dataUrl;

    @GetMapping(value = "application")
    public ResultView<String> getApplication(){
        ResultView<String> result = new ResultView<>();

        result.setCode(ErrorCodeConstant.CODE_SUCCESS);
        result.setData("appName:" + appName + ", dataUrl:" + dataUrl);
        return result;
    }



}
