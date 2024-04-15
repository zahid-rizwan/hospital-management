package com.example.Hospitalmanagmentjava.Repository;

import com.example.Hospitalmanagmentjava.Model.DoctorModel;
import com.example.Hospitalmanagmentjava.Model.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<PatientModel, Integer> {
}
