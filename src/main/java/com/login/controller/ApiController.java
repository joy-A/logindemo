package com.login.controller;

import com.login.pojo.Account;
import com.login.pojo.Result;
import com.login.pojo.StatusCode;
import com.login.pojo.User;
import com.login.service.AccountService;
import com.login.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private AccountService accountService;



    @Autowired
    private UserService userService;
    @GetMapping("/selectUserByaid")
    @ResponseBody
    public Result selectByAid(Integer aid, @RequestHeader("Authorization")String Authorization){
        System.out.println(aid);
        List<User> list = userService.selectByAId(aid);
        System.out.println(list);
        return new Result(StatusCode.OK,list);
    }
    @ApiOperation("查询所有用户信息")
    @PostMapping("/findAllU")
    @ResponseBody

    public Result findAllU(@RequestHeader("Authorization")String Authorization){
        List<User> list = userService.findAllU();
        return new Result(StatusCode.OK,list);
    }
    @ApiOperation("查询所有用户信息")
    @GetMapping("/findAll")
    @ResponseBody
    public Result findAll(@RequestHeader("Authorization")String Authorization){
        List<Account> list = accountService.findAll();
        return new Result(StatusCode.OK,list);
    }

}
