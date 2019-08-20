package edu.udacity.java.nano.chat;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * WebSocket message model
 */
public class Message {
    // TODO: add message model.

    @JSONField(name = "username")
    private String username;

    @JSONField(name = "msg")
    private String message;

    @JSONField(name = "onlineCount")
    private int onlineCount = 0;

    @JSONField(name = "type")
    private String type = "SPEAK";

    public Message(){}

    public Message(String username, String message, int onlineCount, String type){
        this.username = username;
        this.message = message;
        this.onlineCount = onlineCount;
        this.type = type;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setOnlineCount(int onlineCount) {
        this.onlineCount = onlineCount;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }

    public int getOnlineCount() {
        return onlineCount;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
