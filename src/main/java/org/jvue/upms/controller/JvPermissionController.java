package org.jvue.upms.controller;

import com.alibaba.fastjson.JSONObject;
import org.jvue.upms.service.JvPermissionService;
import org.jvue.web.model.WebReponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/upms/permission")
public class JvPermissionController {
    private Object returnModel;
    @Autowired
    private JvPermissionService jvPermissionService;
    @RequestMapping("/list")
    @ResponseBody
    public Object list(){
        return jvPermissionService.listPermissionByUser(1);
      /*  return jvPermissionService.list();*/
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(){
        JSONObject jsonObject= WebReponseModel.SUCCESS;
        returnModel=jsonObject;
        return returnModel;
    }



}