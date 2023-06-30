package managment.netsmartz.service;

import managment.netsmartz.modal.Student;
import managment.netsmartz.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student insertStudent(Student student){
        return studentRepository.save(student);
    }

}
