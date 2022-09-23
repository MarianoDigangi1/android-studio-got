package com.got.trabajopractico.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class House implements Serializable {

    long id;
    String name;
    String region;
    String coatOfArms;

    public House(long id, String name, String region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }
}
