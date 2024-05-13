package com.jwz.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/11
 * @annotation JWT工具类
 */
public class JwtUtils {

    // JWT有效期
    public static final Long JWT_TTL = 60 * 60 * 1000L;
    // 设置签名信息（密钥明文）
    public static final String JWT_KEY = "jwz";


    public static String createJWT(String subject) {
        return getJwtBuilder(subject, JwtUtils.JWT_TTL, getUUID());
    }



    /**
     * @description: 构建JWT 带有特定主题、发行者、ID 和过期时间的 JWT，并使用指定的密钥进行签署，以确保其安全传输
     * @param subject
     * @param ttlMillis
     * @param uuid
     * @return:  JWT
     */
    private static String getJwtBuilder(String subject, Long ttlMillis, String uuid){
        // 1.根据签名信息生成加密后的密钥 secretKey
        SecretKey secretKey = generalKey();
        // 2.获取当前时间戳，ms为单位
        long nowMillis = System.currentTimeMillis();
        // 3.签发时间
        Date now = new Date(nowMillis);
       //4.JWT的过期时间：当前时间戳+JWT过期时间
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);

        return Jwts
                .builder()
//        设置 JWT 的 ID，这通常是一个唯一的标识符。
                .setId(uuid)
//        JWT 的主题（subject），通常用于表示用户或资源的主体
                .setSubject(subject)
//        设置 JWT 的发行者（issuer），在这里是 "jwz"。
                .setIssuer("jwz")
//        设置 JWT 的过期时间。
                .setExpiration(expDate)
//        使用 HS256 算法和之前生成的密钥 secretKey 来签署 JWT
                .signWith(SignatureAlgorithm.HS256, secretKey)
//        完成 JWT 构建并返回一个紧凑的字符串形式的 JWT。
                .compact();
    }


    /**
     * @description:  根据签名信息生成加密后的秘钥 secretKey
     * 从一个 Base64 编码的字符串中提取出一个 AES 加密密钥，
     * 并将其转换为一个可以用于加密或解密操作的 SecretKey 对象。
     * 这种方法通常用于实现 JWT (JSON Web Token) 的签名和验证过程，其中 JWT_KEY 是用于签名和验证 JWT 的密钥。
     * @param
     * @return:
     */
    public static SecretKey generalKey(){
        // 解码 JWT 密钥
        byte[] encodeKey = Base64.getDecoder().decode(JWT_KEY);
        //  创建 SecretKeySpec 对象,使用了 AES (Advanced Encryption Standard) 算法
        SecretKeySpec key = new SecretKeySpec(encodeKey, 0, encodeKey.length, "AES");
        return key;
    }

    /**
     * @description: 生成uuid
     * @param
     * @return:
     */
    public static String getUUID(){
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        return token;
    }
}
