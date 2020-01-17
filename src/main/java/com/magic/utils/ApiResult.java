package com.magic.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName ApiResult
 * @date 2020/1/17 15:39
 */
@Data
public class ApiResult implements Serializable {
    private Integer code;
    private String msg;
    private Object result;

    private ApiResult(Integer code,String msg,Object result){
        this.setResult(result);
        this.setMsg(msg);
        this.setCode(code);
    }
    private ApiResult(){}


    public static ApiResult success(Integer code,String msg,Object result){
        return new ApiResult(code,msg,result);
    }
    public static ApiResult success(){
        return success(200,"操作成功！",null);
    }

    public static ApiResult success(String msg,Object result){
        return success(200,msg,result);
    }

    public static ApiResult success(Integer code,Object result){
        return success(code,"操作成功！",result);
    }

    public static ApiResult success(Object result){
        return success(200,"操作成功！",result);
    }


    public static ApiResult fail(Integer code,String msg,Object result){
        return new ApiResult(code,msg,result);
    }

    public static ApiResult fail(){
        return fail(400,"操作失败!",null);
    }

    public static ApiResult fail(Integer code,String msg){
        return fail(code,msg,null);
    }

    public static ApiResult fail(Integer code){
        return fail(code,"操作失败!",null);
    }

    public static ApiResult fail(String msg){
        return fail(400,msg,null);
    }

    public static ApiResult fail(Integer code,Object result){
        return fail(code,"操作失败！",result);
    }

    public static ApiResult fail(String msg,Object result){
        return fail(400,msg,result);
    }

}
