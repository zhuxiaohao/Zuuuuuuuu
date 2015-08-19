package com.support.android.zzh.bean;

import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Project Name:com.support.android.zzh.bean
 * File Name: Zuuuuuuuu
 * Date:15/8/18下午4:4208
 * blog:http://blog.csdn.net/qq718799510?viewmode=contents
 * Copyright (c) 2015, zhuxiaohao All Rights Reserved.
 * 笑话实体
 */
public class JokeBean extends CommonJson {

    /**
     * item 数据
     */
    public static class JokeBeanInfo {
        private String content;
        private String hashId;
        private String unixtime;
        private String updatetime;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getHashld() {
            return hashId;
        }

        public void setHashld(String hashld) {
            this.hashId = hashld;
        }

        public String getUnixtime() {
            return unixtime;
        }

        public void setUnixtime(String unixtime) {
            this.unixtime = unixtime;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }
    }

    public static List<JokeBeanInfo> parse(String str) throws org.json.JSONException {
        List<JokeBeanInfo> jokeBeanInfo = new ArrayList<JokeBeanInfo>();
        JSONObject jsonObject = new JSONObject(str);
        CommonJson commonJson = new CommonJson();
        commonJson.setError_code(jsonObject.getInt("error_code"));
        commonJson.setReason(jsonObject.getString("reason"));
        JSONObject jsonObject1 = jsonObject.getJSONObject("result");
        JSONArray jsonArray = jsonObject1.getJSONArray("data");
        Type listType = new TypeToken<ArrayList<JokeBeanInfo>>() {
        }.getType();//强制转换对应的类型
        jokeBeanInfo = (List<JokeBeanInfo>) GsonTools.jsonToList(jsonArray.toString(), listType);
        return jokeBeanInfo;
    }
}