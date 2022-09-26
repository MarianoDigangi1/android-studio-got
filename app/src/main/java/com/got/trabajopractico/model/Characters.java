package com.got.trabajopractico.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Characters {

    private String name;
    private String gender;
    private String culture;
    private String born;
    private String died;
}
