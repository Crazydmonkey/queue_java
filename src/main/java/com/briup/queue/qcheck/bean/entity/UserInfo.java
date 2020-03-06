package com.briup.queue.qcheck.bean.entity;

public class UserInfo {
    private Integer subscribe;
    private String openid;
    private String nickname;
    private Integer sex;
    private String city;
    private String province;
    private String country;
    private String headimgurl;
    private Long subscribe_time;

    public UserInfo() {
    }

    public UserInfo(Integer subscribe, String openid, String nickname, Integer sex, String city, String province, String country, String headimgurl, Long subscribe_time) {
        this.subscribe = subscribe;
        this.openid = openid;
        this.nickname = nickname;
        this.sex = sex;
        this.city = city;
        this.province = province;
        this.country = country;
        this.headimgurl = headimgurl;
        this.subscribe_time = subscribe_time;
    }

    public Integer getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Integer subscribe) {
        this.subscribe = subscribe;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Long getSubscribe_time() {
        return subscribe_time;
    }

    public void setSubscribe_time(Long subscribe_time) {
        this.subscribe_time = subscribe_time;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "subscribe=" + subscribe +
                ", openid='" + openid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                ", subscribe_time=" + subscribe_time +
                '}';
    }
}
