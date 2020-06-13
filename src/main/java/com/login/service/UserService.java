package com.login.service;

import com.login.pojo.Account;
import com.login.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface UserService {
    @Select("SELECT uid, info->'$.name', info->'$.sex', info->'$.age' FROM u_info as ui left join u_account as ac on ui.uid=ac.aid where ac.aid=#{aid}")
    public List<User> selectByAId(@Param("aid") Integer aid);
    @Select("select * from u_info")
    List<User> findAllU();
}
