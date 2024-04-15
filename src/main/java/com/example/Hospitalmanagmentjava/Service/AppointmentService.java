package com.example.Hospitalmanagmentjava.Service;

import com.example.Hospitalmanagmentjava.Model.AppointmentModel;
import com.example.Hospitalmanagmentjava.Model.DoctorModel;
import com.example.Hospitalmanagmentjava.Model.PatientModel;
import com.example.Hospitalmanagmentjava.Repository.AppointmentRepo;
import com.example.Hospitalmanagmentjava.Repository.DoctorRepo;
import com.example.Hospitalmanagmentjava.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepo appointmentRepo;
    public void addAppointment(AppointmentModel e)
    {
        appointmentRepo.save(e);

    }
    public List<AppointmentModel> getappointment(){
        return appointmentRepo.findAll();
    }


}
