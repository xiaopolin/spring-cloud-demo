package com.xpl.feign;

import com.xpl.entity.po.UserInfoPO;
import com.xpl.feign.feignImpl.UserInfoFeignImpl;
import com.xpl.framework.ResultView;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "busi-provider/busi-provider/", fallbackFactory = UserInfoFeignImpl.class)
@RequestMapping("userInfo")
public interface UserInfoFeign {

    @GetMapping(value = "user/{id}")
    public ResultView<UserInfoPO> getById(@PathVariable("id") int id);

}
