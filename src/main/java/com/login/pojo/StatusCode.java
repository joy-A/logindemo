package com.login.pojo;

public class StatusCode {
    // 操作成功
    public static final int OK = 200;

    // 失败
    public static final int ERROR = 201;

    // 用户名或密码错误
    public static final int LOGINERROR = 202;

    // token过期
    public static final int TOKENEXPIREE = 203;
}
