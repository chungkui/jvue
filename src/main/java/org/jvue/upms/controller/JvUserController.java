package org.jvue.upms.controller;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.jvue.base.controller.BaseController;
import org.jvue.upms.bean.JvUser;
import org.jvue.upms.service.JvUserService;
import org.jvue.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/upms/user")
public class JvUserController extends BaseController {
    @Autowired
    private JvUserService jvUserService;
    @RequestMapping("/list")
    @ResponseBody
    public Object list(@RequestParam(value = "pageIndex",defaultValue = "1") int pageIndex,
                       @RequestParam(value = "pageSize",defaultValue = "8") int pageSize,
                      JvUser jvUser){
        PageInfo<JvUser> pageInfo=jvUserService.list(jvUser,pageIndex,pageSize);
        return  create200Template(pageInfo,"成功");
    }

    @RequestMapping("/create")
    @ResponseBody
    public Object create(@RequestBody JvUser jvUser){

        jvUserService.create(jvUser);
        return create200Template("","保存成功");
    }
}
