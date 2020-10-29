package com.hackathon.sailors.pregnancyaggregate.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name="form_data")
@Entity
public class DataEntryForm implements Serializable {
    @Id
    private String phoneNumber;
    private String name;
    private String pregnancyStage;
    private String age;
    private String location;
    private String district;
    private String village;
    private String edd;
    private String linkFacility;
    private String linkCu;
    private String ContactCHV;

    public DataEntryForm() {
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getEdd() {
        return edd;
    }

    public void setEdd(String edd) {
        this.edd = edd;
    }

    public String getLinkFacility() {
        return linkFacility;
    }

    public void setLinkFacility(String linkFacility) {
        this.linkFacility = linkFacility;
    }

    public String getLinkCu() {
        return linkCu;
    }

    public void setLinkCu(String linkCu) {
        this.linkCu = linkCu;
    }

    public String getContactCHV() {
        return ContactCHV;
    }

    public void setContactCHV(String contactCHV) {
        ContactCHV = contactCHV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPregnancyStage() {
        return pregnancyStage;
    }

    public void setPregnancyStage(String pregnancyStage) {
        this.pregnancyStage = pregnancyStage;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }


}
