package com.lhb.springboot.utils;

import java.util.UUID;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 10:43 2019/11/13
 */
public class FileNameUtil {

    /**
     * 获取文件后缀
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成新的文件名
     * @param fileOriginName 源文件名
     * @return
     */
    public static String getFileName(String fileOriginName){
        return UUID.randomUUID() + FileNameUtil.getSuffix(fileOriginName);
    }

}