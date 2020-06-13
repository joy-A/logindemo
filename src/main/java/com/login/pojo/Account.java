package com.login.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "u_account")
@Accessors(chain = true)
public class Account implements Serializable {
    @TableId(type = IdType.AUTO ,value = "aid")
    private Integer aid;
    private String username;
    private String passwd;
    private String type;
}

