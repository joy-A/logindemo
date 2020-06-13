package com.login.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.login.pojo.Account;
import com.login.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao extends BaseMapper<User> {
    public List<User> selectByAId(@Param("aid") Integer aid);
}
