package com.tensquare.common.errorcode;


import com.tensquare.common.errorcode.annotations.ECGetCode;
import com.tensquare.common.errorcode.annotations.ECGetHTTPStatus;
import com.tensquare.common.errorcode.annotations.ECGetMessage;
import com.tensquare.common.errorcode.annotations.ErrorCode;

@ErrorCode("default")
public enum SystemErrorCode {
    SUCCESS(0, 200, "Success"),

    ;

    private Integer code;
    private Integer httpCode;
    private String msg;

    SystemErrorCode(Integer code, Integer httpCode, String msg) {
        this.code = code;
        this.httpCode = httpCode;
        this.msg = msg;
    }

    @ECGetCode
    public Integer getCode() {
        return code;
    }

    @ECGetHTTPStatus
    public Integer getHttpCode() {
        return httpCode;
    }

    @ECGetMessage
    public String getMsg() {
        return msg;
    }
}
