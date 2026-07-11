package com.BROPATING.SpringWebDataBase.Service;

import com.BROPATING.SpringWebDataBase.Model.Course;
import com.BROPATING.SpringWebDataBase.Repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepo;

    public List<Course> fetchAllCourse(){
        return courseRepo.findAll();
    }

    public Course fetchCourseByCode(String code){
        return courseRepo.findById(code).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Course with code "+code+" Not Found"
        ));
    }

    public String enrollNewCourse(Course course){
        if(courseRepo.existsById(course.getCode())){
            throw new ResponseStatusException(HttpStatusCode.valueOf(409), "Course is already Exist");
        }
        courseRepo.save(course);
        return "Course Added Successfully";
    }

    public String modifyCourse(Course course){
        Course updatedCourse = fetchCourseByCode(course.getCode());
        updatedCourse.setName(course.getName());
        updatedCourse.setCredits(course.getCredits());
        courseRepo.save(updatedCourse);
        return "Course Updated Successfully";
    }

    public String patchCourse(String code, Course course){
        Course updatedCourse = fetchCourseByCode(code);
        if(course.getName() != null){
            updatedCourse.setName(course.getName());
        }
        if(course.getCredits() != 0){
            updatedCourse.setCredits(course.getCredits());
        }
        courseRepo.save(updatedCourse);
        return "Course Updated Partially";
    }

    public String dropCourse(String code){
//        Course deleteCourse = fetchCourseByCode(code);
//        courseRepo.delete(deleteCourse);
//        return "Course with code "+code+" Drop Successfully";

        if(!courseRepo.existsById(code)){
            throw new ResponseStatusException(HttpStatusCode.valueOf(404), "Course NOT FOUND");
        }
        courseRepo.deleteById(code);
        return "Course with code "+code+" Drop Successfully";
    }
}
