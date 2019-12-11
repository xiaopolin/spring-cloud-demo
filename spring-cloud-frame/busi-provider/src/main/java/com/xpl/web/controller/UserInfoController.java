package com.xpl.web.controller;

import com.xpl.entity.constant.ErrorCodeConstant;
import com.xpl.entity.po.UserInfoPO;
import com.xpl.framework.ResultView;
import com.xpl.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResultView<?> exclude(UserInfoPO userInfoPO){
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

    @PostMapping(value = "user")
    public ResultView<?> insertUser(){

        List<UserInfoPO> userInfoPOS = new ArrayList<>();
        UserInfoPO userInfoPO1 = new UserInfoPO();
        userInfoPO1.setName("aaa");
        userInfoPO1.setPassword("123456");

        userInfoPOS.add(userInfoPO1);

        UserInfoPO userInfoPO2 = new UserInfoPO();
        userInfoPO2.setName("bbb");
        userInfoPO2.setPassword("456789");
        userInfoPOS.add(userInfoPO2);

        userInfoService.insertUserInfo(userInfoPOS);

        return new ResultView<>(ErrorCodeConstant.CODE_SUCCESS);
    }



}
