package com.login.controller;

import com.alibaba.fastjson.JSONObject;
import com.login.pojo.Account;
import com.login.pojo.JsonResult;
import com.login.pojo.User;
import com.login.service.AccountService;
import com.login.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
@Api("测试")
public class UserController {
    @Autowired
    private UserService userService;
    @ResponseBody
    @GetMapping("/selectUserByaid")
    public JsonResult selectByAid(Integer aid){
        System.out.println(aid);
        List<User> list = userService.selectByAId(aid);
        System.out.println(list);
        return new JsonResult(list);
    }
    @ApiOperation("查询所有用户信息")
    @PostMapping("/findAllU")
    @ResponseBody
    public JsonResult findAllU(){
        List<User> list = userService.findAllU();
        return new JsonResult(list);
    }

}

