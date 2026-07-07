package com.BROPATING.SpringBootWEB.Controller;

import com.BROPATING.SpringBootWEB.Model.Course;
import com.BROPATING.SpringBootWEB.Service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<Course> getAllCourse(){
        return courseService.fetchAllCourse();
    }

    @GetMapping("/{courseCode}")
    public Course getCourseByCode(@PathVariable String courseCode){
        return courseService.fetchCourseByCode(courseCode);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course addCourse(@RequestBody Course newCourse){
        return courseService.enrollNewCourse(newCourse);
    }

    @PutMapping
    public Course updateCourse(@RequestBody Course course){
        return courseService.modifyCourse(course);
    }

    @PatchMapping("/{code}")
    public Course patchCourse(@PathVariable String code, @RequestBody Course course) {
        return courseService.patchCourse(code, course);
    }

    @DeleteMapping("/{code}")
    public String deleteCourse(@PathVariable String code){
        courseService.dropCourse(code);
        return "Course Code "+code+ " dropped successfully";
    }

}
