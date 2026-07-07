package com.BROPATING.SpringBootWEB.Service;

import com.BROPATING.SpringBootWEB.Model.Course;
import com.BROPATING.SpringBootWEB.config.DataInitializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Handles the actual business logic for managing courses.
 * It talks directly to our in-memory list to find, add, update, and delete data.
 */
@Service
public class CourseService {
    public List<Course> courseList = DataInitializer.mockCourseDb;

    /**
     * Grabs every single course currently registered in the system.
     * @return List of course
     */
    public List<Course> fetchAllCourse(){
        System.out.println("List of Course: "+ courseList);
        return courseList;
    }

    /**
     * Finds a single course using its specific tracking code.
     * @param code The unique course code (like CS-301) to look for.
     * @return The matching course data if found.
     */
    public Course fetchCourseByCode(String code){
        return courseList.stream()
                .filter(c -> c.getCourseCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Course Code "+code+" Not Found"
                ));
    }

    /**
     *  Adds a new course to our registry after ensuring it isn't a duplicate.
     *  @param newCourse The new course data object being submitted.
     *  @return The successfully added course object.
     */
    public Course enrollNewCourse(Course newCourse){
        boolean isExist = courseList.stream()
                .anyMatch(c -> c.getCourseCode().equalsIgnoreCase(newCourse.getCourseCode()));
        if(isExist){
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(409), "Product is already exist"
            );
        }
        System.out.println("New Enroll Course "+newCourse);
        courseList.add(newCourse);
        return newCourse;
    }

    /**
     * Updates an existing course's details like title and credit hours.
     * @param updatedCourse The object containing the target course code and new data.
     * @return The updated course object reference.
     */
    public Course modifyCourse(Course updatedCourse){
        Course entiy = fetchCourseByCode(updatedCourse.getCourseCode());
        entiy.setTitle(updatedCourse.getTitle());
        entiy.setCredits(updatedCourse.getCredits());
        System.out.println("Modify Course "+entiy);
        return entiy;
    }

    /**
     * Applies a partial update to an existing course.
     * Only fields that are explicitly provided in the request body will be changed.
     * @param code The code of the course to update.
     * @param partialCourse An object containing only the fields that need updating.
     * @return The updated course object.
     */
    public Course patchCourse(String code, Course partialCourse){
        Course course = fetchCourseByCode(code);
        if(partialCourse.getTitle() != null) course.setTitle(partialCourse.getTitle());
        if(partialCourse.getCredits() != null) course.setCredits(partialCourse.getCredits());
        System.out.println("Patched Course: "+course);
        return course;
    }

    /**
     * Deletes a course out of our registry completely.
     * @param code The unique course code identifier to be removed.
     */
    public void dropCourse(String code){
        Course course = fetchCourseByCode(code);
        courseList.remove(course);
        System.out.println("Drop Course "+course);
    }
}
