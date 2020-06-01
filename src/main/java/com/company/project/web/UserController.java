package com.company.project.web;


import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.User;
import com.company.project.service.impl.UserService;
import com.company.project.util.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api("用户管理接口")
@RequestMapping(value = "/user")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@ApiOperation("查询全部")
	@RequestMapping(method = RequestMethod.GET)
    public Result<List<User>> list(HttpServletRequest request) {
        List<User> users = userService.getByMap(null);
        if(users != null && users.size() > 0){
            for (User user : users) {
                user.setPassword(null);
                user.setSalt(null);
            }
        }
        return ResultGenerator.genSuccessResult(users);
    }

    @ApiOperation("根据id查询详情")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result<User> detail(@PathVariable Integer id) {
        User user = userService.getById(id);
        user.setPassword(null);
        user.setSalt(null);
        return ResultGenerator.genSuccessResult(user);
    }

    @ApiOperation("创建用户")
    @RequestMapping(method = RequestMethod.POST)
    public Result create(@RequestBody User user) {
	    if(StringUtils.isBlank(user.getSalt())){
            user.setSalt(MD5Util.getRandomString(5));
        }
	    if(StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())){
	        return ResultGenerator.genFailResult("用户名或密码不能为空");
        }
	    //todo 密码加盐加密

//        user.setPassword(MD5Util.md5(user.getPassword(),user.getSalt()));
        userService.create(user);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation("更新用户")
    @RequestMapping(method = RequestMethod.PUT)
    public Result<User> update(@RequestBody User user) {
        if(StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())){
            return ResultGenerator.genFailResult("用户名或密码不能为空");
        }
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation("删除用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable Integer id) {
        try {
            userService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("删除失败");
        }
        return ResultGenerator.genSuccessResult();
    }
    
}