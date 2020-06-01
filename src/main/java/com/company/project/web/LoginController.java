package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Role;
import com.company.project.model.User;
import com.company.project.service.impl.RoleService;
import com.company.project.service.impl.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cdyoue on 2016/10/21.
 * 登陆控制器
 */
@RestController
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @ApiOperation("登陆接口")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(
            @RequestParam(value = "username", required = true) String userName,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "rememberMe", required = true, defaultValue = "false") boolean rememberMe) {
        logger.info("==========" + userName + password + rememberMe);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        token.setRememberMe(rememberMe);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("您的账号或密码输入错误");
        }
        //在前后端分离的时候sessionID前端拿不到,返回给前端
//        String sessionId = (String) subject.getSession().getId();
        return ResultGenerator.genSuccessResult();
    }


    @ApiOperation("查看是否是管理员角色")
    @PostMapping("/isAdmin")
    public Result isAdmin(){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        if(StringUtils.isBlank(username)){
            return ResultGenerator.genFailResult("用户未登录");
        }
        User user = userService.getByUserName(username);
        if(user != null){
            List<Role> roles = user.getRoles();
            for (Role role : roles) {
                if(role != null){
                    if("admin".equalsIgnoreCase(role.getName())){
                        return ResultGenerator.genSuccessResult(true);
                    }
                }
            }
        }
        return ResultGenerator.genSuccessResult(false);
    }
}
