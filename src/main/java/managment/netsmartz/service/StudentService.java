package managment.netsmartz.service;

import managment.netsmartz.modal.Student;
import managment.netsmartz.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public Student insertStudent(Student student){
        student.setRole("ROLE_USER");
        student.setPassword(encoder.encode(student.getPassword()));
        System.out.println("FINALE /n"+student);
        return studentRepository.save(student);
    }

    public Optional<Student> findStudent(Integer id){
        return studentRepository.findById(id);
    }

    public void deleteStudent(Integer id){
        studentRepository.deleteById(id);
    }

}
