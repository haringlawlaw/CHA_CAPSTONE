package com.capstone.jmt.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Jabito on 15/02/2017.
 */
@Entity
@Table(name="orderStatus")
public class OrderStatus implements Serializable{

    @Id
    @JsonProperty("id")
    @Column(name = "id")
    private String id;
    @Column(name = "requestedOn")
    @JsonProperty("requestedOn")
    private String requestedOn;
    @Column(name="acceptedOn")
    @JsonProperty("acceptedOn")
    private String acceptedOn;
    @Column(name="rejectedOn")
    @JsonProperty("rejectedOn")
    private String rejectedOn;
    @Column(name="retrievedOn")
    @JsonProperty("retrievedOn")
    private String retrievedOn;
    @Column(name="deliveredOn")
    @JsonProperty("deliveredOn")
    private String deliveredOn;
    @Column(name="completedOn")
    @JsonProperty("completedOn")
    private String completedOn;
    @Column(name="cancelledOn")
    @JsonProperty("cancelledOn")
    private String cancelledOn;
    @Column(name="cancelledBy")
    @JsonProperty("cancelledBy")
    private String cancelledBy;
    @Column(name="moreDetails")
    @JsonProperty("moreDetails")
    private String moreDetails;
    @Column(name="currentStatus")
    @JsonProperty("currentStatus")
    private String currentStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRequestedOn() {
        return requestedOn;
    }

    public void setRequestedOn(String requestedOn) {
        this.requestedOn = requestedOn;
    }

    public String getAcceptedOn() {
        return acceptedOn;
    }

    public void setAcceptedOn(String acceptedOn) {
        this.acceptedOn = acceptedOn;
    }

    public String getRejectedOn() {
        return rejectedOn;
    }

    public void setRejectedOn(String rejectedOn) {
        this.rejectedOn = rejectedOn;
    }

    public String getRetrievedOn() {
        return retrievedOn;
    }

    public void setRetrievedOn(String retrievedOn) {
        this.retrievedOn = retrievedOn;
    }

    public String getDeliveredOn() {
        return deliveredOn;
    }

    public void setDeliveredOn(String deliveredOn) {
        this.deliveredOn = deliveredOn;
    }

    public String getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(String completedOn) {
        this.completedOn = completedOn;
    }

    public String getCancelledOn() {
        return cancelledOn;
    }

    public void setCancelledOn(String cancelledOn) {
        this.cancelledOn = cancelledOn;
    }

    public String getCancelledBy() {
        return cancelledBy;
    }

    public void setCancelledBy(String cancelledBy) {
        this.cancelledBy = cancelledBy;
    }

    public String getMoreDetails() {
        return moreDetails;
    }

    public void setMoreDetails(String moreDetails) {
        this.moreDetails = moreDetails;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }
}
