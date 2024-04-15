package com.example.Hospitalmanagmentjava.Repository;

import com.example.Hospitalmanagmentjava.Model.AppointmentModel;
import com.example.Hospitalmanagmentjava.Model.DoctorModel;
import com.example.Hospitalmanagmentjava.Model.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepo extends JpaRepository<AppointmentModel, Integer> {



}
