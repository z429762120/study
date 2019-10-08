package com.tool.collect.skytools.support.alipay;

/**
 * @author Gnoll
 * @create 2017-08-02 21:12
 **/
public class AlipayApiException extends Exception{
    private String            errCode;
    private String            errMsg;

    public AlipayApiException() {
        super();
    }

    public AlipayApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlipayApiException(String message) {
        super(message);
    }

    public AlipayApiException(Throwable cause) {
        super(cause);
    }

    public AlipayApiException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }
}
