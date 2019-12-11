package com.xpl.feign.feignImpl;

import com.xpl.entity.constant.ErrorCodeConstant;
import com.xpl.entity.po.UserInfoPO;
import com.xpl.feign.UserInfoFeign;
import com.xpl.framework.ResultView;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserInfoFeignImpl implements FallbackFactory<UserInfoFeign> {

    @Override
    public UserInfoFeign create(Throwable throwable) {
        return new UserInfoFeign() {

            @Override
            public ResultView<UserInfoPO> getById(int id) {
                ResultView<UserInfoPO> result = new ResultView<>();
                result.setCode(ErrorCodeConstant.ERRORCODE_EXCEPTION);
                result.setMsg("系统异常，Hystrix自动降级");
                log.info(result.toString());
                return result;
            }

        };
    }
}
