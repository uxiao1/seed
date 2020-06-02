package com.company.project.shiro;


import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Description: spring-boot-api-project-seed
 * Created by hua on 2020/6/1 17:36
 *  没有权限访问时返回401状态码
 * @author: wwh
 */
public class ShiroFormAuthenticationFilter extends FormAuthenticationFilter {


    /**
     * 拒绝访问时走的方法
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = this.getSubject(request, response);
        if (subject.getPrincipal() == null) {
            WebUtils.toHttp(response).sendError(401);
        }
        return false;
    }

    /**
     * 控制允许访问方法
     * @param request
     * @param response
     * @param mappedValue
     * @return
     * 前后端分离跨域每次请求之前会发送options请求,这个请求不会携带sessionID,所以需要过滤这个请求
     */
    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //Always return true if the request's method is OPTIONS
        if (request instanceof HttpServletRequest) {
            if (((HttpServletRequest) request).getMethod().toUpperCase().equals("OPTIONS")) {
                return true;
            }
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }
}
