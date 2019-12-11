package com.xpl.entity.po;

import com.xpl.framework.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserInfoPO extends BaseEntity implements Serializable {

    private int id;
    private String name;
    private String password;
    private int role;
    private int state;
    private Date createTime;

}
