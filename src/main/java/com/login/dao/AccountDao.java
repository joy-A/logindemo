package com.login.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.login.pojo.Account;
import com.login.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AccountDao extends BaseMapper<Account> {
    int insert(Account account);
   // @Select("select ac.* from u_info as ui right join u_account as ac on ui.id=ac.aid where info->'$.name'=#{username} and info->'$.sex'=#{sex} and info->'$.age'=#{age}")
    public List<Account> findByUserInfo(@Param("user") User user);

   // @Select("select * from u_account where username=#{username}")
    public List<Account> findByUsername(@Param("username")String username);
  //  @Select("select passwd from u_account where username=#{username}")
    public String findPasswordByU(@Param("username")String username,String passwd);
    @Select("select * from u_account")
    public List<Account> findAll();
}
