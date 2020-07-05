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

    public DataEntryForm() {
    }

    public DataEntryForm(String name, String phoneNumber, String pregnancyStage, String age, String location, String district) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.pregnancyStage = pregnancyStage;
        this.age = age;
        this.location = location;
        this.district = district;
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
