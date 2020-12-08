package com.kexie.videoapp.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class User implements Serializable {
    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "用户昵称")
    private String username;

    @ApiModelProperty(value = "账号： bt + 6~8位随机数")
    private String account;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "1.普通用户  2.会员用户")
    private String type;

    @ApiModelProperty(value = "电话号码")
    private String phone;

    @ApiModelProperty(value = "个性签名")
    private String signature;

    @ApiModelProperty(value = "头像")
    private String headImage;

    @ApiModelProperty(value = "邮箱")
    private String mail;

    @ApiModelProperty(value = "粉丝数")
    private Integer fansNum;

    private String attentionStatus; //粉丝关注状态 ： 1.已关注 2.未关注

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getFansNum() {
        return fansNum;
    }

    public void setFansNum(Integer fansNum) {
        this.fansNum = fansNum;
    }

    public String getAttentionStatus() {
        return attentionStatus;
    }

    public void setAttentionStatus(String attentionStatus) {
        this.attentionStatus = attentionStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", phone='" + phone + '\'' +
                ", signature='" + signature + '\'' +
                ", headImage='" + headImage + '\'' +
                ", mail='" + mail + '\'' +
                ", fansNum=" + fansNum +
                ", attentionStatus='" + attentionStatus + '\'' +
                '}';
    }
}