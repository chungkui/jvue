package org.jvue.base.controller;

import org.jvue.upms.bean.JvUser;
import org.jvue.web.model.ResponseBodyTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;


public class BaseController extends ResponseBodyTemplate {
   public JvUser getLoginUser(){
        return (JvUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    };
    private final static Logger LOGGER = LoggerFactory.getLogger(BaseController.class);



}
