package com.bawei.ykdemo2.bean;

/**
 * 作    者：云凯文
 * 时    间：2017/3/2
 * 描    述：
 * 修改时间：
 */
public class Content {

    private String subject;
    private String nickname;
    private String body;
    private String url;

    public Content() {
    }

    public Content(String subject, String nickname, String body, String url) {
        this.subject = subject;
        this.nickname = nickname;
        this.body = body;
        this.url = url;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Content{" +
                "subject='" + subject + '\'' +
                ", nickname='" + nickname + '\'' +
                ", body='" + body + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
