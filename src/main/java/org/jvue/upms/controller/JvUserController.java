package org.jvue.upms.controller;

import org.jvue.base.controller.BaseController;
import org.jvue.upms.bean.JvUser;
import org.jvue.upms.service.JvUserService;
import org.jvue.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/upms/user")
public class JvUserController extends BaseController {
    @Autowired
    private JvUserService jvUserService;
    @RequestMapping("/list")
    @ResponseBody
    public Object list(){
        Pager pager = new Pager(6, 1, 8);
        List<JvUser> list=jvUserService.list();
        pager.setList(list);
        return  create200Template(pager,"成功");
    }
}
