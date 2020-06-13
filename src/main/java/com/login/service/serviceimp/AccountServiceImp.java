package com.login.service.serviceimp;

import com.login.common.exception.MyServiceException;
import com.login.dao.AccountDao;
import com.login.pojo.Account;
import com.login.pojo.User;
import com.login.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountDao accountDao;


    @Override
    public int insert(Account account) {
        if(account==null){
            throw new MyServiceException("保存的对象不能为空");
        }if(account.getUsername()==null||account.getUsername()==""){
            throw new MyServiceException("用户名不能为空");
        }if(account.getPasswd()==null||account.getPasswd()==""){
            throw new MyServiceException("用户密码不能为空");
        }if(account.getType()==null||account.getType()==""){
            throw new MyServiceException("登录类型不能为空");
        }

        return accountDao.insert(account);
    }

    @Override
    public List<Account> findByUserInfo(User user) {
        return accountDao.findByUserInfo(user);
    }

    @Override
    public List<Account> findByUsername(String username) {
        if(accountDao.findByUsername(username)==null){
            throw new MyServiceException("没有此用户");
        }
        return accountDao.findByUsername(username);
    }

    @Override
    public String findPasswordByU(String username, String passwd) {
        String password = accountDao.findPasswordByU(username,passwd);
        if(passwd==null||passwd==""){
            throw new MyServiceException("登录密码不能为空！");
        }if(!passwd.equals(password)){
            throw new MyServiceException("密码错误！");
        }
        return null;
    }




}
