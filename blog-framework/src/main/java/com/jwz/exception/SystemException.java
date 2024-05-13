package com.jwz.exception;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/11
 * @annotation  系统异常
 */
public class SystemException extends RuntimeException{

    private int code;

    private String message;


    public SystemException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
