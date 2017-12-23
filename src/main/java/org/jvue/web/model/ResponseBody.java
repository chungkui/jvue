package org.jvue.web.model;

import com.alibaba.fastjson.JSONObject;

public class ResponseBody {
    /*响应状态*/
    public Integer state;
    /*描述*/
    public String message;
    /*业务数据*/
    public Object data;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
