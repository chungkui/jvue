package org.jvue;

import org.jvue.upms.bean.Menu;
import org.jvue.upms.mapper.MenuMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping("/")
public class JsonControl {
    private static final Logger logger = LoggerFactory.getLogger(JsonControl.class);

    @Resource(name="menuMapper")
    private  MenuMapper menuMapper;
    //映射一个action
    @RequestMapping("/index")
    public  String index(){
        List    <Menu>list=menuMapper.list();
        //输出日志文件
        logger.info("the first jsp pages");
        //返回一个index.jsp这个视图
        return "index";
    }
}
