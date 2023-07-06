package managment.netsmartz.service;

import managment.netsmartz.modal.Course;
import managment.netsmartz.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course insertCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAll(){
        return courseRepository.findAll();
    }

    public Optional<Course> getCourse(Integer id){
        return courseRepository.findById(id);
    }

    public void deleteCourse(Integer id){
        courseRepository.deleteById(id);
    }

//    public Course updateCourse(Integer id, Course course){
//        Course courseOld = courseRepository.findById(id).get();
//        if(courseOld != null){
//            courseOld.setName(course.getName());
//            courseOld.setFees(course.getFees());
//            courseOld.setTrainer_name(course.getTrainer_name());
//            return courseRepository.save(courseOld);
//        }else{
//            System.out.println("NOT FOUND");
//            return null;
//        }
//    }


}
