package com.example.Hospitalmanagmentjava.Repository;

import com.example.Hospitalmanagmentjava.Model.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<DoctorModel, Integer> {
}
