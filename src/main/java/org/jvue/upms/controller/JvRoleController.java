package org.jvue.upms.controller;

import com.github.pagehelper.PageInfo;
import org.jvue.base.controller.BaseController;
import org.jvue.upms.bean.JvRole;
import org.jvue.upms.service.JvRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/upms/role")
public class JvRoleController extends BaseController{
    @Autowired
    private JvRoleService jvRoleService;

    @RequestMapping("/list")
    @ResponseBody
    public Object list(@RequestParam(value = "currentPage",defaultValue = "1") int currentPage,
                       @RequestParam(value = "pageSize",defaultValue = "8") int pageSize, JvRole jvRole) {
        PageInfo pageInfo = jvRoleService.list(jvRole, currentPage, pageSize);
        return  create200Template(pageInfo,"成功");
    }
}
