package com.myproject.entitiy;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
@Document
public class Kullanici {
    @Id
    private String Id;
    private String Name;
    private String LastName;
    private HashMap Properties;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public HashMap getProperties() {
        return Properties;
    }

    public void setProperties(HashMap properties) {
        Properties = properties;
    }
}
