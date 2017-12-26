package org.jvue.upms.controller;

import org.jvue.upms.bean.JvUser;
import org.jvue.upms.service.JvUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/upms/user")
public class JvUserController {
    @Autowired
    private JvUserService jvUserService;
    @RequestMapping("/list")
    @ResponseBody
    public Object list(){
        List<JvUser> list=jvUserService.list();
        return  list;
    }
}
