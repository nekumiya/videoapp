package com.kexie.videoapp.condition;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by 欲隐君。 on 2020/10/30
 */
public class MessageCondition {

    private Integer id;

    private Integer objectId;

    private String announcerAccount;

    private String subscriberAccount;

    private String title;

    private String content;

    private String msgType;

    private String msgStatus;

    private Date sendTime;

    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getAnnouncerAccount() {
        return announcerAccount;
    }

    public void setAnnouncerAccount(String announcerAccount) {
        this.announcerAccount = announcerAccount;
    }

    public String getSubscriberAccount() {
        return subscriberAccount;
    }

    public void setSubscriberAccount(String subscriberAccount) {
        this.subscriberAccount = subscriberAccount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(String msgStatus) {
        this.msgStatus = msgStatus;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
