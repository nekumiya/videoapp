package com.kexie.videoapp.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Collect implements Serializable {
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "收藏对象id")
    private Integer videoId;

    @ApiModelProperty(value = "用户account")
    private String userAccount;

    @ApiModelProperty(value = "收藏时间")
    private Date collectTime;

    @ApiModelProperty(value = "收藏状态:  1.已收藏   2.取消收藏")
    private String collectStatus;

    private Integer collectNum; //已收藏次数

    private Video video;

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

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    public String getCollectStatus() {
        return collectStatus;
    }

    public void setCollectStatus(String collectStatus) {
        this.collectStatus = collectStatus;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", videoId=" + videoId +
                ", userAccount='" + userAccount + '\'' +
                ", collectTime=" + collectTime +
                ", collectStatus='" + collectStatus + '\'' +
                ", collectNum=" + collectNum +
                ", video=" + video +
                '}';
    }
}