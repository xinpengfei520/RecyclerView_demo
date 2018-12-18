package com.xpf.recyclerview.entity;

/**
 * Created by x-sir on 2018/12/12 :)
 * Function:
 */
public class FourTypeBean {

    private String content;
    private int logoId;

    public FourTypeBean() {
    }

    public FourTypeBean(String content, int logoId) {
        this.content = content;
        this.logoId = logoId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLogoId() {
        return logoId;
    }

    public void setLogoId(int logoId) {
        this.logoId = logoId;
    }
}
