package com.jwz.domain.response;

import com.jwz.enums.APPCodeMappingEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/11
 * @annotation 返回参数，泛型
 */

@Data
public class ResponseResult<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    public ResponseResult() {
        this.code = APPCodeMappingEnum.SUCCESS.getCode();
        this.message = APPCodeMappingEnum.SUCCESS.getMsg();
    }

    public ResponseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(int code, T data) {
        this.code = code;
        this.data = data;
    }
    public ResponseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public static ResponseResult okResult(){
        ResponseResult responseResult = new ResponseResult();
        return responseResult;
    }

    public static ResponseResult okResult(int code, String message){
        ResponseResult responseResult = new ResponseResult();
        return responseResult.ok(code, null, message);
    }



    public static ResponseResult okResult( Object data) {
        ResponseResult responseResult = new ResponseResult();
        if(data!=null) {
            responseResult.setData(data);
        }
        return responseResult;
    }







    public ResponseResult<?> ok(Integer code, T data, String message){
        this.code = code;
        this.message = message;
        this.data= data;
        return this;
    }
    
    
}
