package com.example.postgres_demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.postgres_demo.StudentManagment.Course;
public interface CourseRepository extends JpaRepository<Course, Integer> {
    
}
