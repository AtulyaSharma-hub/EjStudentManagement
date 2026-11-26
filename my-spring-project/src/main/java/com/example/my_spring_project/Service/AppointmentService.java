package com.example.my_spring_project.Service;

import java.util.ArrayList;
import java.util.List;
import com.example.my_spring_project.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.my_spring_project.model.Appointment;

@Service 
public class AppointmentService {
    private List<Appointment> appointments = new ArrayList<>();

    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    public Appointment getAppointmentById(int id) {

        for (Appointment appointment : appointments) {
            if (appointment.getId() == id) {
                return appointment;
            }
        }

        throw new ResourceNotFoundException("Appointment with ID " + id + " not found");
    }   
    public Appointment addAppointment(
            Appointment appointment) {

        appointments.add(appointment);

        return appointment;
    }

    public boolean deleteAppointment(int id) {

        return appointments.removeIf(
                appointment ->
                        appointment.getId() == id
        );
    }
}
