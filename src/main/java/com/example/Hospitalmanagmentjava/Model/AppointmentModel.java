package com.example.Hospitalmanagmentjava.Model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="appointment")
public class AppointmentModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String doctorName;
    private String patientName;
    private String date;

//    @ManyToOne(targetEntity = DoctorModel.class,cascade = CascadeType.ALL)
//    @JoinColumn(name="did",referencedColumnName = "id")
//    private List<DoctorModel> doctorlist;

//    @ManyToOne(targetEntity = PatientModel.class,cascade = CascadeType.ALL)
//    @JoinColumn(name="pid",referencedColumnName = "id")
//    private List<PatientModel> patientlist;


    public AppointmentModel() {
        super();
    }

    public AppointmentModel(int id, String doctorName, String patientName, String date) {
        this.id = id;
        this.doctorName = doctorName;
        this.patientName = patientName;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "AppointmentModel{" +
                "id=" + id +
                ", doctorName='" + doctorName + '\'' +
                ", patientName='" + patientName + '\'' +
                ", date=" + date +
                '}';
    }
}