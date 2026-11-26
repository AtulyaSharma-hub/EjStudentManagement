package com.example.my_spring_project.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.my_spring_project.model.Doctor;
import com.example.my_spring_project.Service.DoctorService;

@RestController 
@RequestMapping("/doctors")
public class DoctorController {
    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // GET /doctors
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {

        return ResponseEntity.ok(
            doctorService.getAllDoctors()
        );
    }
     // GET /doctors/1
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable int id) {

        Doctor doctor =
                doctorService.getDoctorById(id);

        if (doctor == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(doctor);
    }

    // GET /doctors/specialization?name=Cardiologist
    @GetMapping("/specialization")
    public ResponseEntity<List<Doctor>>
            getDoctorsBySpecialization(
                @RequestParam String name) {

        return ResponseEntity.ok(
            doctorService
                .getDoctorsBySpecialization(name)
        );
    }

    // POST /doctors
    @PostMapping
    public ResponseEntity<Doctor> addDoctor(
            @RequestBody Doctor doctor) {

        Doctor newDoctor =
                doctorService.addDoctor(doctor);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newDoctor);
    }

    // PUT /doctors/1
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(
            @PathVariable int id,
            @RequestBody Doctor doctor) {

        Doctor updatedDoctor =
                doctorService.updateDoctor(id, doctor);

        if (updatedDoctor == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedDoctor);
    }

    // DELETE /doctors/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable int id) {
         boolean deleted = doctorService.deleteDoctor(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Doctor deleted successfully");
    }

}
