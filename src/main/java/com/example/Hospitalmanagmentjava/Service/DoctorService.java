package com.example.Hospitalmanagmentjava.Service;

import com.example.Hospitalmanagmentjava.Model.DoctorModel;
import com.example.Hospitalmanagmentjava.Repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;
    public void addDoctor(DoctorModel e)
    {
        doctorRepo.save(e);
    }

    public List<DoctorModel> getdoctor(){
       return doctorRepo.findAll();
    }
}
