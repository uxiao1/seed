package com.company.project.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * Description: spring-boot-api-project-seed
 * Created by hua on 2020/6/1 16:14
 *  自定义sessionManage,前后端分离项目从请求头带过来的sessionID,自己去从request headers中取值
 * @author: wwh
 */
public class MySessionManager extends DefaultWebSessionManager{

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        //TODO 注意,这个token是前端sessionId的key
        String token = httpServletRequest.getHeader("sessionId");
        System.out.println("sessionId："+token);
        if(!StringUtils.isEmpty(token)){
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, "sessionId");
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, token);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return token;

        }else{
            return super.getSessionId(request, response);
        }
    }
}
