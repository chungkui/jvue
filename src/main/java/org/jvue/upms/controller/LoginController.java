package org.jvue.upms.controller;


import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.net.HttpUtils;
import org.jvue.web.model.ResponseBodyTemplate;
import org.jvue.web.model.WebReponseModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/upms/login")
public class LoginController extends ResponseBodyTemplate {
    @RequestMapping("/dispatch")
    @ResponseBody
    public Object dispatch(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return create300Template(null,"您需要登陆");
    }
    @RequestMapping("/success")
    @ResponseBody
    public Object success(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
    /*    JSONObject jsonObject=new JSONObject();
        jsonObject=WebReponseModel.SUCCESS;
        jsonObject.put("JSESSIONID",httpServletRequest.getSession().getId());
        */
        JSONObject data=new JSONObject();
        data.put("JSESSIONID",httpServletRequest.getSession().getId());
        return create200Template(data,"登陆成功");
        /*return "forward:/loginPageAjax";*/
    }


}
