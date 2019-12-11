package com.xpl.framework;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xpl.entity.constant.ErrorCodeConstant;
import lombok.Data;

@Data
public class ResultView<T> extends BaseEntity {

    private int code;
    private String msg = "";
    private T data;

    public ResultView(){
    }

    public ResultView(int code){
        this.code = code;
    }

    public ResultView(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResultView(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultView<T> getResult(JSONObject data, Class<T> clazz){
        ResultView<T> result = new ResultView<>();

        if (null == data){
            result.setCode(ErrorCodeConstant.ERRORCODE_RESULT_NULL);
            result.setMsg(ErrorCodeConstant.ERRORMSG_RESULT_NULL);
            return result;
        }

        JSONObject dataJson = data.getJSONObject("data");
        T dataData = null != dataJson ? JSON.parseObject(dataJson.toJSONString(), clazz) : null;

        result.setCode(data.getInteger("code"));
        result.setMsg(data.getString("msg"));
        result.setData(dataData);
        return result;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
