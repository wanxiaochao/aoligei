package com.alg.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

/**
 * Description: 返回结果类
 */
public class RetUtil implements Serializable {

    private static final long serialVersionUID = -5094108153544666502L;

    public static final Integer OK = 9000;// 接口调用成功
    public static final Integer ERR = 9999;// 接口调用失败

    public static String OK() {
        long currentime = System.currentTimeMillis();
        return "{\"code\":" + OK + ",\"msg\":" + "\"请求成功！\"" + ",\"currentime\":" + currentime + "}";
    }

    public static <T> String OK(T result) {
        String ret = JSON.toJSONString(result, SerializerFeature.DisableCircularReferenceDetect);
        long currentime = System.currentTimeMillis();
        return "{\"code\":" + OK + ",\"ret\":" + ret + ",\"msg\":" + "\"请求成功！\"" + ",\"currentime\":" + currentime
                + "}";
    }

    public static <T> String OK(T result, String msg) {
        String ret = JSON.toJSONString(result, SerializerFeature.DisableCircularReferenceDetect);
        long currentime = System.currentTimeMillis();
        return "{\"code\":" + OK + ",\"ret\":" + ret + ",\"msg\":" + "\"" + msg + "\"" + ",\"currentime\":" + currentime
                + "}";
    }

    public static <T> String OK(T result, Integer currentPage) {
        String ret = JSON.toJSONString(result, SerializerFeature.DisableCircularReferenceDetect);
        long currentime = System.currentTimeMillis();
        return "{\"code\":" + OK + ",\"ret\":" + ret + ",\"msg\":" + "\"请求成功！\"" + ",\"currentime\":" + currentime
                + ",\"currentPage\":" + currentPage + "}";
    }

    public static <T> String OK(T result, Integer currentPage, String msg) {
        String ret = JSON.toJSONString(result, SerializerFeature.DisableCircularReferenceDetect);
        long currentime = System.currentTimeMillis();
        return "{\"code\":" + OK + ",\"ret\":" + ret + ",\"msg\":" + "\"" + msg + "\"" + ",\"currentime\":" + currentime
                + ",\"currentPage\":" + currentPage + "}";
    }

    public static String ERR() {
        long currentime = System.currentTimeMillis();
        return "{\"code\":" + ERR + ",\"msg\":" + "\"系统异常，正在修复！\"" + ",\"currentime\":" + currentime + "}";
    }

    public static String ERR(String msg) {
        long currentime = System.currentTimeMillis();
        return "{\"code\":" + ERR + ",\"msg\":" + "\"" + msg + "\"" + ",\"currentime\":" + currentime + "}";
    }

    public static String ERR(Integer code, String msg) {
        long currentime = System.currentTimeMillis();
        return "{\"code\":" + code + ",\"msg\":" + "\"" + msg + "\"" + ",\"currentime\":" + currentime + "}";
    }

    public static <T> String ERR(Integer code, T result, String msg) {
        String ret = JSON.toJSONString(result, SerializerFeature.DisableCircularReferenceDetect);
        long currentime = System.currentTimeMillis();
        return "{\"code\":" + code + ",\"ret\":" + ret + ",\"msg\":" + "\"" + msg + "\"" + ",\"currentime\":"
                + currentime + "}";
    }

}
