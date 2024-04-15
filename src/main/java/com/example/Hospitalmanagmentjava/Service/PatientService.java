package com.example.Hospitalmanagmentjava.Service;

import com.example.Hospitalmanagmentjava.Model.DoctorModel;
import com.example.Hospitalmanagmentjava.Model.PatientModel;
import com.example.Hospitalmanagmentjava.Repository.DoctorRepo;
import com.example.Hospitalmanagmentjava.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;
    public void addPatient(PatientModel e)
    {
        patientRepo.save(e);
    }
    public List<PatientModel> getPatient(){
        return patientRepo.findAll();
    }
}
