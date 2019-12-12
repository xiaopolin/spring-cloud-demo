package com.xpl.controller;

import com.xpl.entity.constant.ErrorCodeConstant;
import com.xpl.entity.po.UserInfoPO;
import com.xpl.framework.ResultView;
import com.xpl.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping(value = "feignConfigGetUser/{id}")
    public ResultView<UserInfoPO> feignGetUser(@PathVariable("id") int id){
        ResultView<UserInfoPO> result = new ResultView<>();

        UserInfoPO userInfoPO = userInfoService.getById(id);

        result.setCode(ErrorCodeConstant.CODE_SUCCESS);
        result.setData(userInfoPO);
        return result;
    }

}
