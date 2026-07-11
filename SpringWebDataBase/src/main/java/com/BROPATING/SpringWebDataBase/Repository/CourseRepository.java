package com.BROPATING.SpringWebDataBase.Repository;

import com.BROPATING.SpringWebDataBase.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    // JpaRepository automatically gives you:
    // .findAll(), .findById(), .save(), .deleteById(), and .existsById()
}
