package com.example.Hospitalmanagmentjava.Model;

import javax.persistence.*;

@Entity
@Table(name="patient")
public class PatientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String gender;
    private String phno;
    private String address;

    public PatientModel() {
      super();
    }

    public PatientModel(int id, String name, String gender, String phno, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phno = phno;
        this.address = address;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PatientModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phno='" + phno + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
