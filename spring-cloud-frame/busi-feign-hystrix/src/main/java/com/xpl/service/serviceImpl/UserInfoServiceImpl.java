package com.xpl.service.serviceImpl;

import com.xpl.entity.constant.ErrorCodeConstant;
import com.xpl.entity.po.UserInfoPO;
import com.xpl.feign.UserInfoFeign;
import com.xpl.framework.ResultView;
import com.xpl.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoFeign userInfoFeign;

    @Override
    public UserInfoPO getById(int id) {
        ResultView<UserInfoPO> userInfoPOResultView = userInfoFeign.getById(id);
        return userInfoPOResultView.getData();
    }
}
