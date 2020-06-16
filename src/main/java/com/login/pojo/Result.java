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
public class Result {
    private Integer code;
    private String msg="请求成功";
    private Object data;
    public Result(int code){
        super();
        this.code=code;
    }
    public Result(String msg){
        super();
        this.msg=msg;
    }
    public Result(Object data){
        super();
            this.data=data;
    }

    public Result(Integer code, String msg) {
        super();
        this.code=code;
        this.msg=msg;
    }
    public Result(Integer code, Object data) {
        super();
        this.code=code;
        this.data=data;
    }

    public static Result create(Integer code,String msg){
        return new Result(code,msg);
    }
    public static Result create(Integer code,String msg,Object data){
        return new Result(code,msg,data);
    }
}
