package com.login;

import com.login.common.exception.MyServiceException;
import com.login.dao.AccountDao;
import com.login.dao.UserDao;
import com.login.pojo.Account;
import com.login.pojo.User;
import com.login.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LogindemoApplicationTests {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private UserDao userDao;
    @Test
    void contextLoads() {
        List<Account> account = accountDao.findByUsername("张三");
        //List<User> user = userDao.selectByAId(1);
        System.out.println(account);
       // System.out.println(user);
    }
    @Test
    void testinsert(){
        Account account = new Account();
        account.setUsername("accountname").setPasswd("passwd").setType("type");
        int rows = accountDao.insert(account);
        System.out.println(rows);
    }
    @Test
    void testlogin(){
        String passwd="passwd";
        String password = accountDao.findPasswordByU("accountname",passwd);
        if(passwd==null||passwd==""){
            throw new MyServiceException("登录密码不能为空！");
        }if(!passwd.equals(password)){
            throw new MyServiceException("密码错误！"+password);
        }
        System.out.println("forward:getAccountByUname");
    }

}
