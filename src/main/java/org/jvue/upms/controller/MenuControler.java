package org.jvue.upms.controller;

import com.alibaba.fastjson.JSONObject;
import org.jvue.upms.mapper.MenuMapper;
import org.jvue.web.model.WebReponseModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/upms/menu")
public class MenuControler {
    private Object returnModel;
    @Resource(name="menuMapper")
    private MenuMapper menuMapper;
    @RequestMapping("/list")
    @ResponseBody
    public Object list(){
      /*String pageIndewx=  request.getParameter("pageIndex");*/
        return menuMapper.list();
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(){
        menuMapper.delete("1");

        JSONObject jsonObject= WebReponseModel.SUCCESS;

        returnModel=jsonObject;

        return returnModel;
    }



}
