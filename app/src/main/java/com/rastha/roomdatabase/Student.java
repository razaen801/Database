package com.rastha.roomdatabase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity

public class Student {
    @PrimaryKey
    private int id;

    private String name;
    private String faculy;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculy() {
        return faculy;
    }

    public void setFaculy(String faculy) {
        this.faculy = faculy;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
