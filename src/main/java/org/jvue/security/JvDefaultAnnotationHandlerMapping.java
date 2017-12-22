package org.jvue.security;

import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;

import javax.servlet.http.HttpServletRequest;

public class JvDefaultAnnotationHandlerMapping extends DefaultAnnotationHandlerMapping {

    @Override
    public Object getHandlerInternal(HttpServletRequest request) throws Exception {
        return super.getHandlerInternal(request);
    }
}
