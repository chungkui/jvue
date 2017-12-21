package org.jvue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class JsonControl {
    private static final Logger logger = LoggerFactory.getLogger(JsonControl.class);
    //映射一个action
    @RequestMapping("/index")
    public  String index(){
      /*  List    <Menu>list=menuMapper.list();*/
        //输出日志文件
        logger.info("the first jsp pages");
        //返回一个index.jsp这个视图
        return "index";
    }
}
