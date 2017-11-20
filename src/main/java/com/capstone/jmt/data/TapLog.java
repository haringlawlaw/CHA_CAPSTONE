package com.capstone.jmt.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Jabito on 17/11/2017.
 */
public class TapLog implements Serializable{
    @JsonProperty("rfid")
    private String rfid;
    @JsonProperty("logType")
    private String logType;
    @JsonProperty("logDateTime")
    private Date logDateTime;

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public Date getLogDateTime() {
        return logDateTime;
    }

    public void setLogDateTime(Date logDateTime) {
        this.logDateTime = logDateTime;
    }
}
