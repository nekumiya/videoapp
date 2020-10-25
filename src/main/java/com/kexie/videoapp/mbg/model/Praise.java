package com.kexie.videoapp.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Praise implements Serializable {
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "点赞对象id")
    private Integer videoId;

    @ApiModelProperty(value = "用户account")
    private String userAccount;

    @ApiModelProperty(value = "点赞时间")
    private Date praiseTime;

    @ApiModelProperty(value = "点赞状态： 1.已点赞  2. 取消点赞")
    private String praiseStatus;

    private Integer praiseNum; //已点赞次数

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public Date getPraiseTime() {
        return praiseTime;
    }

    public void setPraiseTime(Date praiseTime) {
        this.praiseTime = praiseTime;
    }

    public String getPraiseStatus() {
        return praiseStatus;
    }

    public void setPraiseStatus(String praiseStatus) {
        this.praiseStatus = praiseStatus;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    @Override
    public String toString() {
        return "Praise{" +
                "id=" + id +
                ", videoId=" + videoId +
                ", userAccount='" + userAccount + '\'' +
                ", praiseTime=" + praiseTime +
                ", praiseStatus='" + praiseStatus + '\'' +
                ", praiseNum=" + praiseNum +
                '}';
    }
}