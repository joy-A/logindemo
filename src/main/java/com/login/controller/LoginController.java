package com.login.controller;

import com.login.common.config.util.JwtUtil;
import com.login.common.exception.MyServiceException;
import com.login.common.filter.JwtFilter;
import com.login.pojo.Account;
import com.login.pojo.Result;
import com.login.pojo.StatusCode;
import com.login.service.AccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AccountService accountService;
    /**
     * 添加一个账户信息
     * @param accountname
     * @param passwd
     * @param type
     * @return
     */
    @ApiOperation(value="注册", notes="注册账户")
    @PostMapping(value = "/addAccount")
    @ResponseBody
    public Result addAccount(String accountname, String passwd, String type){
        Account account = new Account();
        account.setUsername(accountname).setPasswd(passwd).setType(type);
        int rows = accountService.insert(account);
        return new Result(StatusCode.OK,"注册成功！",account);
    }
    @RequestMapping(value = "check",method = RequestMethod.POST)
    @ResponseBody
    public Result getLoginInfo(String username, String passwd){
        Account loginaccount = new Account();
        loginaccount.setUsername(username).setPasswd(passwd);

        if(isValidPasswd(loginaccount)){
            String jwt = JwtUtil.generateToken(loginaccount.getUsername());
            Map map = new HashMap();
            map.put("token",jwt);
            System.out.println(map);
            return Result.create(StatusCode.OK,"登录成功",map);
        }else {
            return Result.create(StatusCode.LOGINERROR,"登陆失败,用户或密码错误");
        }

    }

    private boolean isValidPasswd(Account account) {

        Account AccountDB = accountService.findByUsername1(account.getUsername());
        if(account==null||account.getUsername()==null){
            System.out.println(new MyServiceException("用户为空"));
            return false;
        }
        if(AccountDB.getUsername().equals(account.getUsername())&&AccountDB.getPasswd().equals(account.getPasswd())){
            return true;
        }else {
            return false;
        }

    }
    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        JwtFilter filter = new JwtFilter();
        registrationBean.setFilter(filter);
        return registrationBean;
    }


}
