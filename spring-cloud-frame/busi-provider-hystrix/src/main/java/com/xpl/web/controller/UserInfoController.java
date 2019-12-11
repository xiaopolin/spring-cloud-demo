package com.xpl.web.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.xpl.entity.constant.ErrorCodeConstant;
import com.xpl.entity.po.UserInfoPO;
import com.xpl.framework.ResultView;
import com.xpl.framework.util.RandomUtil;
import com.xpl.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    @HystrixCommand(fallbackMethod = "getUserHystrix")
    public ResultView<UserInfoPO> getUser(@PathVariable("id") int id) throws InterruptedException {
        ResultView<UserInfoPO> result = new ResultView<>();

        Random random = new Random();
        int code = random.nextInt(9) + 1;
        log.info("获取到数字：" + code);
        if (code < 4){
            throw new RuntimeException();
        } else if (code < 8) {

            Thread.sleep(1000);

            result.setCode(ErrorCodeConstant.ERRORCODE_EXCEPTION);
            result.setMsg("超时");
            return result;
        }

        result.setCode(ErrorCodeConstant.CODE_SUCCESS);
        result.setData(userInfoService.getById(id));
        return result;
    }

    public ResultView<UserInfoPO> getUserHystrix(@PathVariable("id") int id){
        ResultView<UserInfoPO> result = new ResultView<>();

        result.setCode(ErrorCodeConstant.ERRORCODE_EXCEPTION);
        result.setMsg("系统异常，Hystrix熔断触发");
        return result;

    }




}
