package com.example.my_spring_project.Service;
import com.example.my_spring_project.exception.ResourceNotFoundException;
import com.example.my_spring_project.model.Patient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service 
public class PatientService {
    List<Patient> patients = new ArrayList<>();
    public PatientService() {
        patients.add(new Patient(1, "Rahul", 25, "Fever"));
        patients.add(new Patient(2, "Priya", 32, "Diabetes"));
    }

    public List<Patient> getAllPatients() {
        return patients;
    }

    public Patient getPatientById(int id) {
        for(Patient patient : patients) {
            if(patient.getId() == id) return patient;
        }
        throw new ResourceNotFoundException("Patient with ID " + id + " not found");
    }

    public Patient addPatient(Patient patient) {
        patients.add(patient);
        return patient;
    } 

    public Patient updatePatient(int id,Patient updatedPatient) {
        Patient existingPatient = getPatientById(id);
        if(existingPatient == null) return null;
        
        existingPatient.setName(updatedPatient.getName());
        existingPatient.setAge(updatedPatient.getAge());
        existingPatient.setDisease(updatedPatient.getDisease());

        return existingPatient;
    }
    public boolean deletePatient(int id) {
        return patients.removeIf(patient -> patient.getId() == id);
    }
    
}
