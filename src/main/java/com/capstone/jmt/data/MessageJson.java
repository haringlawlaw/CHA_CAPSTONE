package com.capstone.jmt.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jabito on 16/11/2017.
 */
public class MessageJson implements Serializable{

    @JsonProperty("messageTypeId")
    private Integer messageTypeId;
    @JsonProperty("message")
    private String message;
    @JsonProperty("postedBy")
    private String postedBy;
    @JsonProperty("messageTarget")
    private ArrayList<String> messageTarget;

    public Integer getMessageTypeId() {
        return messageTypeId;
    }

    public void setMessageTypeId(Integer messageTypeId) {
        this.messageTypeId = messageTypeId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public ArrayList<String> getMessageTarget() {
        return messageTarget;
    }

    public void setMessageTarget(ArrayList<String> messageTarget) {
        this.messageTarget = messageTarget;
    }
}
