package com.kexie.videoapp.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Attention implements Serializable {
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "被关注者account")
    private String followAccount;

    @ApiModelProperty(value = "粉丝account")
    private String fansAccount;

    @ApiModelProperty(value = "关注时间")
    private Date attentionTime;

    @ApiModelProperty(value = "关注状态： 1.已关注  2.未关注")
    private String status;

    private Integer attentionNum; //已收藏次数

    private User up;

    private User fans;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFollowAccount() {
        return followAccount;
    }

    public void setFollowAccount(String followAccount) {
        this.followAccount = followAccount;
    }

    public String getFansAccount() {
        return fansAccount;
    }

    public void setFansAccount(String fansAccount) {
        this.fansAccount = fansAccount;
    }

    public Date getAttentionTime() {
        return attentionTime;
    }

    public void setAttentionTime(Date attentionTime) {
        this.attentionTime = attentionTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAttentionNum() {
        return attentionNum;
    }

    public void setAttentionNum(Integer attentionNum) {
        this.attentionNum = attentionNum;
    }

    public User getUp() {
        return up;
    }

    public void setUp(User up) {
        this.up = up;
    }

    public User getFans() {
        return fans;
    }

    public void setFans(User fans) {
        this.fans = fans;
    }

    @Override
    public String toString() {
        return "Attention{" +
                "id=" + id +
                ", followAccount='" + followAccount + '\'' +
                ", fansAccount='" + fansAccount + '\'' +
                ", attentionTime=" + attentionTime +
                ", status='" + status + '\'' +
                ", attentionNum=" + attentionNum +
                ", up=" + up +
                ", fans=" + fans +
                '}';
    }
}