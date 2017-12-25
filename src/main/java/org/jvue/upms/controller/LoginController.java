package org.jvue.upms.controller;


import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.net.HttpUtils;
import org.jvue.upms.bean.JvUser;
import org.jvue.web.model.ResponseBodyTemplate;
import org.jvue.web.model.WebReponseModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

        JSONObject data=new JSONObject();
        data.put("JSESSIONID",httpServletRequest.getSession().getId());
        JvUser jvUser=(JvUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        data.put("userinfo",jvUser);
        return create200Template(data,"登陆成功");

    }

    @RequestMapping("/userinfo")
    @ResponseBody
    public Object userinfo(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        JSONObject data=new JSONObject();
         JvUser jvUser=(JvUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return create200Template(jvUser,"获取成功");
    }
}
