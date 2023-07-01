package managment.netsmartz.controller;

import managment.netsmartz.modal.Course;
import managment.netsmartz.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/insert")
    public Course insertCourse(@RequestBody Course course) {
        System.out.println(course);
        return courseService.insertCourse(course);
    }

    @GetMapping("/get/{id}")
    public Optional<Course> getCourse(@PathVariable Integer id) {
        return courseService.getCourse(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
    }

    @PutMapping("/update/{id}")
    public Course updateCourse(@PathVariable Integer id, @RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }


}
