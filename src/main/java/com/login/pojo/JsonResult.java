package com.login.pojo;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class JsonResult {
    private Integer code=200;
    private String msg="请求成功";
    private Object data;
    public JsonResult(int code){
        super();
        this.code=code;
    }
    public JsonResult(String msg){
        super();
        this.msg=msg;
    }
    public JsonResult(Object data){
        super();
        if(data instanceof JSON){
            this.data=((JSON) data).toString();
        }else {
            this.data=data;
        }

    }
    public JsonResult(Throwable throwable){
        this.code=201;
        this.msg=throwable.getMessage();
    }
}
