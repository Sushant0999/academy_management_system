package managment.netsmartz.controller;

import managment.netsmartz.modal.Course;
import managment.netsmartz.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
