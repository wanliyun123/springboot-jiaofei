package com.myapplication.jiaofei.pojo;

import java.io.Serializable;
import java.util.Date;

public class Useraccount implements Serializable {
    private Integer userId;

    private String userName;

    private String userCity;

    private Double userMoney;

    private Date userBorndate;

    private Integer userSex;

    private Double waterPay;

    private Double phonePay;

    private Double elecPay;

    private Integer typeId;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity == null ? null : userCity.trim();
    }

    public Double getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(Double userMoney) {
        this.userMoney = userMoney;
    }

    public Date getUserBorndate() {
        return userBorndate;
    }

    public void setUserBorndate(Date userBorndate) {
        this.userBorndate = userBorndate;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public Double getWaterPay() {
        return waterPay;
    }

    public void setWaterPay(Double waterPay) {
        this.waterPay = waterPay;
    }

    public Double getPhonePay() {
        return phonePay;
    }

    public void setPhonePay(Double phonePay) {
        this.phonePay = phonePay;
    }

    public Double getElecPay() {
        return elecPay;
    }

    public void setElecPay(Double elecPay) {
        this.elecPay = elecPay;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", userCity=").append(userCity);
        sb.append(", userMoney=").append(userMoney);
        sb.append(", userBorndate=").append(userBorndate);
        sb.append(", userSex=").append(userSex);
        sb.append(", waterPay=").append(waterPay);
        sb.append(", phonePay=").append(phonePay);
        sb.append(", elecPay=").append(elecPay);
        sb.append(", typeId=").append(typeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}