package com.kexie.videoapp.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "评论对象id")
    private Integer objectId;

    @ApiModelProperty(value = "被留言者account")
    private String announcerAccount;

    @ApiModelProperty(value = "留言者account")
    private String subscriberAccount;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "消息类型： 1.文本  2.表情  3.弹幕  4.送礼物  5系统")
    private String msgType;

    @ApiModelProperty(value = "消息状态：  1.已读  2.未读")
    private String msgStatus;

    @ApiModelProperty(value = "发送时间")
    private Date sendTime;

    private User subscriber; //留言者

    private Video video;

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    private static final long serialVersionUID = 1L;

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

    public User getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(User subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", objectId=" + objectId +
                ", announcerAccount='" + announcerAccount + '\'' +
                ", subscriberAccount='" + subscriberAccount + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", msgType='" + msgType + '\'' +
                ", msgStatus='" + msgStatus + '\'' +
                ", sendTime=" + sendTime +
                ", subscriber=" + subscriber +
                ", video=" + video +
                '}';
    }
}