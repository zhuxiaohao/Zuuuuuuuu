package com.support.android.zzh.bean;

import com.google.gson.JsonIOException;

/**
 * Project Name:com.support.android.zzh.bean
 * File Name: Zuuuuuuuu
 * Date:15/8/19上午11:3208
 * blog:http://blog.csdn.net/qq718799510?viewmode=contents
 * Copyright (c) 2015, zhuxiaohao All Rights Reserved.
 */
public class TestBean extends CommonJson {


    /**
     * item 数据
     */
    public static class TestBeanInfo {

        private String province;//省份
        private String city;// 城市
        private String areacode;//区号
        private String zip;// 邮编
        private String company;//运营商
        private String card;//卡类型

        public String getAreacode() {
            return areacode;
        }

        public void setAreacode(String areacode) {
            this.areacode = areacode;
        }

        public String getCard() {
            return card;
        }

        public void setCard(String card) {
            this.card = card;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }
    }


    /**
     * 解析数据
     *
     * @param str
     *         数据
     *
     * @return
     *
     * @throws JsonIOException
     */
    public static TestBeanInfo parse(String str) throws org.json.JSONException {
        TestBeanInfo testBean = new TestBeanInfo();
        org.json.JSONObject jsonObject = new org.json.JSONObject(str);
        CommonJson commonJson = new CommonJson();
        commonJson.setError_code(jsonObject.getInt("error_code"));
        commonJson.setReason(jsonObject.getString("reason"));
        org.json.JSONObject jsonObject1 = jsonObject.getJSONObject("result");
        testBean = (TestBeanInfo) GsonTools.jsonToBean(jsonObject1.toString(), TestBeanInfo.class);
        return testBean;
    }
}
