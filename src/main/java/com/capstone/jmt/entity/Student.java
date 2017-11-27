package com.capstone.jmt.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Jabito on 25/08/2017.
 */
@Entity
public class Student implements Serializable{

    @JsonProperty("id")
    private String id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("middleName")
    private String middleName;
    private String fullName;
    @JsonProperty("bday")
    private Date bday;
    @JsonProperty("place")
    private String place;
    @JsonProperty("gender")
    private Integer gender;
    @JsonProperty("citizenship")
    private String citizenship;
    @JsonProperty("address")
    private String address;
    @JsonProperty("contactNo")
    private String contactNo;
    @JsonProperty("emergencyContact")
    private String emergencyContact;
    @JsonProperty("gradeLvlId")
    private Integer gradeLvlId;
    @JsonProperty("schoolYear")
    private Integer schoolYear;
    @JsonProperty("section")
    private String section;
    @JsonProperty("isOldStudent")
    private Boolean isOldStudent;
    @JsonProperty("isTransferee")
    private Boolean isTransferee;
    @JsonProperty("rfid")
    private String rfid;
    @JsonProperty("isEnrolled")
    private Boolean isEnrolled;
            @JsonProperty("createdBy")
    private String createdBy;
    @JsonProperty("createdOn")
    private Date createdOn;
    @JsonProperty("updatedBy")
    private String updatedBy;
    @JsonProperty("updatedOn")
    private Date updatedOn;

    public Student(){}

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getBday() {
        return bday;
    }

    public void setBday(Date bday) {
        this.bday = bday;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public Integer getGradeLvlId() {
        return gradeLvlId;
    }

    public void setGradeLvlId(Integer gradeLvlId) {
        this.gradeLvlId = gradeLvlId;
    }

    public Integer getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(Integer schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Boolean getOldStudent() {
        return isOldStudent;
    }

    public void setOldStudent(Boolean oldStudent) {
        isOldStudent = oldStudent;
    }

    public Boolean getTransferee() {
        return isTransferee;
    }

    public void setTransferee(Boolean transferee) {
        isTransferee = transferee;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public Boolean getEnrolled() {
        return isEnrolled;
    }

    public void setEnrolled(Boolean enrolled) {
        isEnrolled = enrolled;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
}
