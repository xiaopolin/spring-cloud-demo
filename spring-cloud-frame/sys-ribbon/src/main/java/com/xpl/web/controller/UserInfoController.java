package com.xpl.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.xpl.entity.constant.ErrorCodeConstant;
import com.xpl.entity.po.UserInfoPO;
import com.xpl.framework.ResultView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("userInfo")
public class UserInfoController {

    private static final String BUSI_PROVIDER_PREFIX = "http://busi-provider/busi-provider/";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "ribbonGetUser/{id}")
    public ResultView<UserInfoPO> ribbonGetUser(@PathVariable("id") int id){
        ResultView<UserInfoPO> result = new ResultView<>();
        JSONObject jsonResult = restTemplate.getForObject(BUSI_PROVIDER_PREFIX + "userInfo/user/" + id, JSONObject.class);

        result = result.getResult(jsonResult, UserInfoPO.class);

        return result;
    }



}
