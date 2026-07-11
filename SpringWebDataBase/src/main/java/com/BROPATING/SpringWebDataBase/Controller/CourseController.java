package com.BROPATING.SpringWebDataBase.Controller;

import com.BROPATING.SpringWebDataBase.Model.Course;
import com.BROPATING.SpringWebDataBase.Service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/course")
@RequiredArgsConstructor
@Controller
public class CourseController {
    private final CourseService courseService;
    @GetMapping
    public List<Course> getCourse(){
        return courseService.fetchAllCourse();
    }

    @GetMapping("/{code}")
    public Course fetchById(@PathVariable String code){
        return courseService.fetchCourseByCode(code);
    }

    @PostMapping
    public String addNewCourse(@RequestBody Course course){
        return courseService.enrollNewCourse(course);
    }

    @PutMapping
    public String editCourse(@RequestBody Course course){
        return courseService.modifyCourse(course);
    }

    @PatchMapping("/{code}")
    public String partialUpdate(@PathVariable String code, @RequestBody Course course){
        return courseService.patchCourse(code, course);
    }

    @DeleteMapping("/{code}")
    public String deleteCourse(@PathVariable String code){
        return courseService.dropCourse(code);
    }
}
