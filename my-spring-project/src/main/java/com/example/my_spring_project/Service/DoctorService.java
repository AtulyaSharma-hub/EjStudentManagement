package com.example.my_spring_project.Service;

import org.springframework.stereotype.Service;

import com.example.my_spring_project.exception.ResourceNotFoundException;
import com.example.my_spring_project.model.Doctor;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    private List<Doctor> doctors = new ArrayList<>();

    public DoctorService() {
        doctors.add(
            new Doctor(1, "Dr. Sharma", "Cardiologist")
        );

        doctors.add(
            new Doctor(2, "Dr. Mehta", "Neurologist")
        );

        doctors.add(
            new Doctor(3, "Dr. Kapoor", "Dermatologist")
        );
    }

    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    public Doctor getDoctorById(int id) {

        for (Doctor doctor : doctors) {

            if (doctor.getId() == id) {
                return doctor;
            }
        }
        throw new ResourceNotFoundException("Doctor with ID " + id + " not found");
    }

    public Doctor addDoctor(Doctor doctor) {

        doctors.add(doctor);

        return doctor;
    }

    public Doctor updateDoctor(int id,Doctor updatedDoctor) {

        Doctor existingDoctor = getDoctorById(id);

        if (existingDoctor == null) {
            return null;
        }

        existingDoctor.setName(
            updatedDoctor.getName()
        );

        existingDoctor.setSpecialization(
            updatedDoctor.getSpecialization()
        );

        return existingDoctor;
    }

    public boolean deleteDoctor(int id) {

        return doctors.removeIf(
            doctor -> doctor.getId() == id
        );
    }   

    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        return doctors.stream().filter(doctor -> doctor.getSpecialization().equalsIgnoreCase(specialization)).toList();
    }
}
