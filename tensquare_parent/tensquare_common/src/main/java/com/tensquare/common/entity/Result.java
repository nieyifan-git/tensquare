package com.tensquare.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nieyifan
 * @createTime 2019/11/20 14:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private boolean flag;
    private Integer code;
    private String message;
    private Object data;

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public static Result susccess(Object data){
        return new Result(true,StatusCode.OK,"操作成功",data);
    }
    public static Result susccess(){
        return new Result(true,StatusCode.OK,"操作成功");
    }
    public static Result error(){
        return new Result(false,StatusCode.ERROR,"操作失败");
    }
    public static Result error(String message){
        return new Result(false,StatusCode.ERROR,message);
    }

}
