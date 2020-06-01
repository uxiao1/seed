package com.company.project.shiro;


import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Description: spring-boot-api-project-seed
 * Created by hua on 2020/6/1 17:36
 *  没有权限访问时返回401状态码
 * @author: wwh
 */
public class ShiroFormAuthenticationFilter extends FormAuthenticationFilter {


    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = this.getSubject(request, response);
        if (subject.getPrincipal() == null) {
            WebUtils.toHttp(response).sendError(401);
        }
        return false;
    }
}
