package com.xpf.recyclerview.entity;

/**
 * Created by xpf on 2018/12/25 :)
 * Function:StatusEntity
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class StatusEntity {

    private boolean isResend;
    private String text;
    private String userName;
    private String userAvatar;
    private String createdAt;

    public StatusEntity() {
    }

    public StatusEntity(boolean isResend, String text, String userName, String userAvatar, String createdAt) {
        this.isResend = isResend;
        this.text = text;
        this.userName = userName;
        this.userAvatar = userAvatar;
        this.createdAt = createdAt;
    }

    public boolean isResend() {
        return isResend;
    }

    public void setResend(boolean resend) {
        isResend = resend;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
