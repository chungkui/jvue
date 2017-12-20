package org.jvue.upms.controller;

import com.alibaba.fastjson.JSONObject;
import org.jvue.upms.service.JpermissionService;
import org.jvue.web.model.WebReponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/upms/permission")
public class JpermissionControler {
    private Object returnModel;
    @Autowired
    private JpermissionService jPermissionService;

    @RequestMapping("/list")
    @ResponseBody
    public Object list(){
        return jPermissionService.list();
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(){


        JSONObject jsonObject= WebReponseModel.SUCCESS;

        returnModel=jsonObject;

        return returnModel;
    }



}
