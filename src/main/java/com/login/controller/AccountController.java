package com.login.controller;

import com.alibaba.fastjson.JSON;
import com.login.pojo.Account;
import com.login.pojo.JsonResult;
import com.login.pojo.User;
import com.login.service.AccountService;
import com.login.service.UserService;
import io.swagger.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired private AccountService accountService;

    /**
     * 添加一个账户信息
     * @param accountname
     * @param passwd
     * @param type
     * @return
     */
    @ApiOperation(value="测试数据1", notes="注册账户")
    @PostMapping(value = "/addAccount")
    @ResponseBody
    public JsonResult addAccount(String accountname,String passwd,String type){
        Account account = new Account();
        account.setUsername(accountname).setPasswd(passwd).setType(type);
        int rows = accountService.insert(account);
        return new JsonResult("注册成功！");
    }

    @ApiOperation(value="测试数据3", notes="登录账户")
    @GetMapping("/log")
    public String tologin(){
        return "login";
    }
    @GetMapping("/Zc")
    public String toDl(){
        return "zc";
    }


    @GetMapping(value = "/login")
    public String loginAccount(String accountname,String passwd){
        String password = accountService.findPasswordByU(accountname,passwd);

        return "redirect:/account/getAccountByUname";
    }
    /**
     **
     ** 根据用户名称获取登录账户信息
     **
     **@param accountname
     **@return
     */
    @ApiOperation(value="测试数据2", notes="获取account")
    @PostMapping("/getAccountByUname")
    @ResponseBody
    public JsonResult selectAll(String accountname,String passwd){
        List<Account> list =  accountService.findByUsername(accountname);
        System.out.println("获取的信息"+list);
        return new JsonResult(list);
    }

}
