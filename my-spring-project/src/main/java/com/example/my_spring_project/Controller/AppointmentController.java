package com.example.my_spring_project.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.my_spring_project.Service.AppointmentService;
import com.example.my_spring_project.model.Appointment;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private AppointmentService appointmentService;

    public AppointmentController(
            AppointmentService appointmentService) {

        this.appointmentService = appointmentService;
    }   

    // GET /appointments
    @GetMapping
    public ResponseEntity<List<Appointment>>
            getAllAppointments() {

        return ResponseEntity.ok(
                appointmentService.getAllAppointments()
        );
    }

    // GET /appointments/1
    @GetMapping("/{id}")
    public ResponseEntity<Appointment>
            getAppointmentById(
                    @PathVariable int id) {

        Appointment appointment = appointmentService.getAppointmentById(id);

        return ResponseEntity.ok(appointment);
    }

    // POST /appointments
    @PostMapping 
    public ResponseEntity<Appointment> addAppointment(@Valid @RequestBody Appointment appointment ) {
        Appointment newAppointment = appointmentService.addAppointment(appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAppointment);
    }

    // DELETE /appointments/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String>
            deleteAppointment(
                    @PathVariable int id) {

        boolean deleted = appointmentService.deleteAppointment(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                "Appointment deleted successfully"
        );
    }   
}
