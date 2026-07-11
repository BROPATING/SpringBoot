package com.BROPATING.SpringWebDataBase.Config;

import com.BROPATING.SpringWebDataBase.Model.Course;
import com.BROPATING.SpringWebDataBase.Repository.CourseRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // Automatically injects the CourseRepository below
public class DataInitializer {

    private final CourseRepository courseRepo;

    @PostConstruct
    public void loadInitialData() {
        // Optional: Clear out any leftover database state on startup
        courseRepo.deleteAll();

        // Save initial course records directly into the H2 Database table
        courseRepo.save(new Course("CS-301", "Computer Vision", 4));
        courseRepo.save(new Course("CS-302", "Natural Language Processing", 3));
        courseRepo.save(new Course("CS-401", "Cloud Computing Architecture", 4));

        System.out.println(">>> H2 Database successfully pre-populated with initial courses!");
    }
}