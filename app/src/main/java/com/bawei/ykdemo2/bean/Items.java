package com.bawei.ykdemo2.bean;

/**
 * 作    者：云凯文
 * 时    间：2017/3/2
 * 描    述：
 * 修改时间：
 */
public class Items {

    private String content;
    private String infoAvatar;

    public Items() {
    }

    public Items(String content, String infoAvatar) {
        this.content = content;
        this.infoAvatar = infoAvatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getInfoAvatar() {
        return infoAvatar;
    }

    public void setInfoAvatar(String infoAvatar) {
        this.infoAvatar = infoAvatar;
    }

    @Override
    public String toString() {
        return "Items{" +
                "content='" + content + '\'' +
                ", infoAvatar='" + infoAvatar + '\'' +
                '}';
    }
}
