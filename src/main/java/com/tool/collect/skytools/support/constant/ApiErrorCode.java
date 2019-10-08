package com.tool.collect.skytools.support.constant;

/**
 * 接口返回码
 *
 * @author xieyj
 * @create 2017-08-09 18:02
 **/
public enum ApiErrorCode {
    /**
     *
     */
    Success(200,"Success"),
    /**
     * 请求参数错误
     */
    Param_Error(100,"Param_Error"),
    /**
     * 签名校验错误
     */
    Sign_Error(300,"Sign_Error"),
    /**
     * 时间校验错误
     */
    Time_Error(301,"Time_Error"),
    /**
     * 验证码校验错误
     */
    Code_Error(304,"Code_Error"),
    /**
     * 奖励已领取
     */
    Receive_Error(305,"Receive_Error"),
    /**
     * 系统异常
     */
    System_Error(400,"System_Error"),
    /**
     * 系统异常
     */
    User_Not_Exist(401,"User_Not_Exist");

    private long code;
    private String msg;

    ApiErrorCode(long code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
