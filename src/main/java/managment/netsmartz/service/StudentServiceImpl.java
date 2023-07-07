package managment.netsmartz.service;

import managment.netsmartz.modal.Student;
import managment.netsmartz.repository.StudentRepository;
import managment.netsmartz.repository.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public Student insertStudent(Student student) {
        student.setRole("ROLE_USER");
        student.setPassword(encoder.encode(student.getPassword()));
        return studentRepository.save(student);
    }

    public Optional<Student> findStudent(Integer id) {
        return studentRepository.findById(id);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }


    @Override
    public boolean checkEmail(String email) {
        return studentRepository.existsByEmail(email);
    }
}
