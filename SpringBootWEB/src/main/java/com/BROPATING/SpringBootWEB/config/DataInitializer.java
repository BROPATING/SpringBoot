package com.BROPATING.SpringBootWEB.config;

import com.BROPATING.SpringBootWEB.Model.Course;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class DataInitializer {
    public static final List<Course> mockCourseDb = new CopyOnWriteArrayList<>();

    @PostConstruct
    public void initSampleData() {
        mockCourseDb.add(new Course("CS-301", "Computer Vision", 4));
        mockCourseDb.add(new Course("CS-302", "Natural Language Processing", 3));
        mockCourseDb.add(new Course("CS-401", "Cloud Computing Architecture", 4));
        System.out.println(">>> Mock Course DB initialized successfully with " + mockCourseDb.size() + " tracks.");
    }
}
