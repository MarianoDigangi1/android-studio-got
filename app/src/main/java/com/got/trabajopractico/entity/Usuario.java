package com.got.trabajopractico.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DatabaseTable(tableName = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @DatabaseField(id = true)
    private int id;
    @DatabaseField(columnName = "username")
    private String username;
    @DatabaseField(columnDefinition = "email")
    private String email;
    @DatabaseField(columnDefinition = "password")
    private String password;
}
