package com.capstone.jmt.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Jabito on 15/02/2017.
 */
public class ContainersOffered implements Serializable {

    @Id
    @JsonProperty("id")
    @Column(name = "id")
    private String id;
    @Column(name = "roundOffered")
    @JsonProperty("roundOffered")
    private Boolean roundOffered;
    @Column(name="slimOffered")
    @JsonProperty("slimOffered")
    private Boolean slimOffered;
    @Column(name="roundQuantity")
    @JsonProperty("roundQuantity")
    private Integer roundQuantity;
    @Column(name="slimQuantity")
    @JsonProperty("slimQuantity")
    private Integer slimQuantity;
    @Column(name="createdOn")
    @JsonProperty("createdOn")
    private String createdOn;
    @Column(name="updatedOn")
    @JsonProperty("updatedOn")
    private String updatedOn;
    @Column(name="updatedBy")
    @JsonProperty("updatedBy")
    private String updatedBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getRoundOffered() {
        return roundOffered;
    }

    public void setRoundOffered(Boolean roundOffered) {
        this.roundOffered = roundOffered;
    }

    public Boolean getSlimOffered() {
        return slimOffered;
    }

    public void setSlimOffered(Boolean slimOffered) {
        this.slimOffered = slimOffered;
    }

    public Integer getRoundQuantity() {
        return roundQuantity;
    }

    public void setRoundQuantity(Integer roundQuantity) {
        this.roundQuantity = roundQuantity;
    }

    public Integer getSlimQuantity() {
        return slimQuantity;
    }

    public void setSlimQuantity(Integer slimQuantity) {
        this.slimQuantity = slimQuantity;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
