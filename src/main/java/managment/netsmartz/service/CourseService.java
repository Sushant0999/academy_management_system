package managment.netsmartz.service;

import managment.netsmartz.modal.Course;
import managment.netsmartz.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course insertCourse(Course course) {
        return courseRepository.save(course);
    }
}
