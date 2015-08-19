package com.support.android.zzh.bean;

/**
 * Project Name:com.support.android.zzh.bean
 * File Name: Zuuuuuuuu
 * Date:15/8/19下午2:1108
 * blog:http://blog.csdn.net/qq718799510?viewmode=contents
 * Copyright (c) 2015, zhuxiaohao All Rights Reserved.
 * 聚合数据解析  父类
 */
public class CommonJson{


    private int error_code;//	int	返回码
    private String reason;//	返回说明
    private String result;//返回结果集



    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
