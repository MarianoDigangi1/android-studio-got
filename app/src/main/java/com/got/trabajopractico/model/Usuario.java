package com.got.trabajopractico.model;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
