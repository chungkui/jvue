package org.jvue.web.model;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public  class WebReponseModel {

     public  static JSONObject SUCCESS= JSON.parseObject("{state:200,description:'成功'}");

    public static JSONObject FAIL=JSON.parseObject("{state:500,description:'失败'}");

}
