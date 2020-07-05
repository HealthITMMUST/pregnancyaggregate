package com.hackathon.sailors.pregnancyaggregate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PregnantMotherData {

    @Id
    @GeneratedValue
    private int id;
    private String fullName;
    private String age;
    private String village;
    private String numberOfCildren;

    public PregnantMotherData() {
    }

    public String getNumberOfCildren() {
        return numberOfCildren;
    }

    public void setNumberOfCildren(String numberOfCildren) {
        this.numberOfCildren = numberOfCildren;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }
}
