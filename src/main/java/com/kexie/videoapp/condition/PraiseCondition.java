package com.kexie.videoapp.condition;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by 欲隐君。 on 2020/10/25
 */
public class PraiseCondition {
    private Integer id;

    private Integer videoId;

    private String userAccount;

    private Date praiseTime;

    private String praiseStatus;

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
}
