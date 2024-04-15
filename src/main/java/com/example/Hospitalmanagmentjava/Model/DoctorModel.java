package com.example.Hospitalmanagmentjava.Model;

import javax.persistence.*;

@Entity
@Table(name="doctor")
public class DoctorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phno;
    private String special;

    public DoctorModel() {
        super();
    }

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

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    @Override
    public String toString() {
        return "HospitalModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phno='" + phno + '\'' +
                ", special='" + special + '\'' +
                '}';
    }



}
