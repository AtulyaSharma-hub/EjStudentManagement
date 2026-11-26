package com.example.my_spring_project.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.my_spring_project.model.Patient;
import com.example.my_spring_project.Service.PatientService;

@RestController 
@RequestMapping("/patients")
public class PatientController {
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    
    // GET /patients
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    // GET /patients/1
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable int id) {

        Patient patient = patientService.getPatientById(id);

        if (patient == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(patient);
    }
    // GET /patients/search?age=25
    @GetMapping("/search")
    public ResponseEntity<List<Patient>> searchPatientsByAge(@RequestParam int age) {
        List<Patient> res = patientService.getAllPatients().stream().filter(patient -> patient.getAge()==age).toList();
        return ResponseEntity.ok(res);
    }

      // POST /patients
    @PostMapping
    public ResponseEntity<Patient> addPatient(
            @RequestBody Patient patient) {

        Patient newPatient = patientService.addPatient(patient);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newPatient);
      }
    // PUT /patients/1
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(
            @PathVariable int id,
            @RequestBody Patient patient) {

        Patient updatedPatient = patientService.updatePatient(id, patient);
        
        if (updatedPatient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPatient);
    }

    // DELETE /patients/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable int id) {
        boolean deleted = patientService.deletePatient(id);

        if(!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Patient deleted Successfully");
    }
}
