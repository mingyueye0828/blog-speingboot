package com.jwz.utils;


import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/13
 * @annotation 下载excel的
 */
public class DownloadExcelUtils {

    
    /**
     * @description: 下载excel
     * @param fileName 文件名称
     * @param response 响应
     * @throws: UnsupportedEncodingException 不支持编码异常
     */
    public static void setDownloadHeader(String fileName, HttpServletResponse response) throws UnsupportedEncodingException {
        //这表明要下载的文件是 Excel 格式的电子表格
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        //设置 HTTP 响应的字符编码为 UTF-8
        response.setCharacterEncoding("utf-8");

        // 这里URLEncoder.encoder可以防止中文乱码,将编码后的空格替换为 %20，因为在 URL 中空格应该使用 %20 表示
        String fName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
        //设置 HTTP 响应头的 Content-disposition 字段，指定浏览器如何处理响应体。
        // attachment 表示以附件形式下载，filename= 后面跟着的是下载的文件名，
        // 这里使用了编码后的文件名，并添加了 .xlsx 扩展名，表明下载的文件是 Excel 格式的电子表格
        response.setHeader("Content-disposition", "attachment;filename=" + fName + ".xlsx");
        
    }

}
