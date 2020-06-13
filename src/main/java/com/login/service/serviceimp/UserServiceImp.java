package com.login.service.serviceimp;

import com.login.dao.UserDao;
import com.login.pojo.Account;
import com.login.pojo.User;
import com.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectByAId(Integer aid) {
        System.out.println(aid);
        userDao.selectByAId(aid);
        return userDao.selectByAId(aid);
    }
}
