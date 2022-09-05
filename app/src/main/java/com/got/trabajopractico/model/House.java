package com.got.trabajopractico.model;

public class House {

    long id;
    String name;
    String region;
    String coatOfArms;

    public House(){

    }

    public House(long id, String name, String region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }

    public House(long id, String name, String region, String coatOfArms) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.coatOfArms = coatOfArms;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCoatOfArms() {
        return coatOfArms;
    }

    public void setCoatOfArms(String coatOfArms) {
        this.coatOfArms = coatOfArms;
    }
}
