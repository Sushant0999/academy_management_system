package managment.netsmartz.controller;

import managment.netsmartz.modal.Course;
import managment.netsmartz.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@PreAuthorize("ROLE_ADMIN")
@RequestMapping("/admin/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/get/{id}")
    public Optional<Course> getCourse(@PathVariable Integer id) {
        return courseService.getCourse(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
    }



}
