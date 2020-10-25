package com.kexie.videoapp.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Video implements Serializable {
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "标签")
    private String labels;

    @ApiModelProperty(value = "简介")
    private String description;

    @ApiModelProperty(value = "视频封面")
    private String coverImage;

    @ApiModelProperty(value = "视频文件路径")
    private String videoUrl;

    @ApiModelProperty(value = "视频文件类型")
    private String videoType;

    @ApiModelProperty(value = "上传时间")
    private Date updateTime;

    @ApiModelProperty(value = "播放次数")
    private Integer watchNum;

    @ApiModelProperty(value = "收藏数")
    private Integer collectNum;

    @ApiModelProperty(value = "点赞数")
    private Integer praiseNum;

    @ApiModelProperty(value = "用户account")
    private String userAccount;

    @ApiModelProperty(value = "分类id")
    private Integer categoryId;

    private String username; //上传视频用户的用户名

    private String collectStatus; //收藏状态 ： 1.已收藏 2.未收藏

    private String praiseStatus; //点赞状态:  1.已点赞 2.未点赞

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getWatchNum() {
        return watchNum;
    }

    public void setWatchNum(Integer watchNum) {
        this.watchNum = watchNum;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCollectStatus() {
        return collectStatus;
    }

    public void setCollectStatus(String collectStatus) {
        this.collectStatus = collectStatus;
    }

    public String getPraiseStatus() {
        return praiseStatus;
    }

    public void setPraiseStatus(String praiseStatus) {
        this.praiseStatus = praiseStatus;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", labels='" + labels + '\'' +
                ", description='" + description + '\'' +
                ", coverImage='" + coverImage + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", videoType='" + videoType + '\'' +
                ", updateTime=" + updateTime +
                ", watchNum=" + watchNum +
                ", collectNum=" + collectNum +
                ", praiseNum=" + praiseNum +
                ", userAccount='" + userAccount + '\'' +
                ", categoryId=" + categoryId +
                ", username='" + username + '\'' +
                ", collectStatus='" + collectStatus + '\'' +
                ", praiseStatus='" + praiseStatus + '\'' +
                '}';
    }
}