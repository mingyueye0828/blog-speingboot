package com.jwz.utils;

import java.util.UUID;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/11
 * @annotation 图片新名称，防止重复
 */
public class ImageUtils {
    /**
     * @description:
     * @param originalFilename
     * @return:
     */
    public static String generateFilePath(String originalFilename) {
//        生成UUID
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//        获取到文件后缀名，截取字符串
        int index = originalFilename.lastIndexOf(".");
        String fileType = originalFilename.substring(index);
        return new StringBuilder().append(uuid).append(fileType).toString();
    }

}
