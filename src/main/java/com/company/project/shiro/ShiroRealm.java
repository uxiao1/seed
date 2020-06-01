package com.company.project.shiro;


import com.company.project.dao.PermissionDao;
import com.company.project.dao.UserDao;
import com.company.project.model.Permission;
import com.company.project.model.Role;
import com.company.project.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by cdyoue on 2016/10/21.
 */

public class ShiroRealm extends AuthorizingRealm {
    private static Logger logger =  LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired(required = false)
    private UserDao userService;
    @Autowired(required = false)
    private PermissionDao permissionService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("doGetAuthorizationInfo+"+principalCollection.toString());
        User user = userService.getByUserName((String) principalCollection.getPrimaryPrincipal());

        //把principals放session中 key=userId value=principals
        SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(user.getId()), SecurityUtils.getSubject().getPrincipals());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //赋予角色
        for(Role userRole:user.getRoles()){
            info.addRole(userRole.getName());
        }
        //赋予权限
        List<Permission> permissionList = permissionService.getByUserId(user.getId());
        for (Permission permission : permissionList) {
            if(permission != null) {
                info.addStringPermission(permission.getName());
            }
        }

        //设置登录次数、时间
//        userService.updateUserLogin(user);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("doGetAuthenticationInfo +"  + authenticationToken.toString());

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName=token.getUsername();

        User user = userService.getByUserName(token.getUsername());
        if (user != null) {
            //todo 加盐算法
//            byte[] salt = user.getSalt().getBytes();
//            ByteSource byteSource = ByteSource.Util.bytes(salt);
            //设置用户session
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("user", user);
//            return new SimpleAuthenticationInfo(userName,user.getPassword(),byteSource,getName());
            return new SimpleAuthenticationInfo(userName,user.getPassword(),getName());
        } else {
            return null;
        }
//        return null;
    }

}
