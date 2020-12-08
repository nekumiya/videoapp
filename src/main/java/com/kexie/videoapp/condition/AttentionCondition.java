package com.kexie.videoapp.condition;

import com.kexie.videoapp.mbg.model.User;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by 欲隐君。 on 2020/11/30
 */
public class AttentionCondition {
    private Integer id;
    private String followAccount;
    private String fansAccount;
    private Date attentionTime;
    private String status;
    private String time;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
