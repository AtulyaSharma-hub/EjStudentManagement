package com.example.postgres_demo.StudentManagment;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.CascadeType;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;


@Entity
@Table(name = "students")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank (message = "Student name cannot be blank")
    private String name;
    
    @NotBlank (message = "Student email cannot be blank")
    @Email (message = "Invalid email format")
    private String email;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference 
    private List<Course> courses = new ArrayList<>();

    // Default constructor
    public Student() {
    }

    // Parameterized constructor
    public Student(String name, String email) {
        
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourses() {
        return courses;
    }
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
