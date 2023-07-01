package managment.netsmartz.service;

import managment.netsmartz.modal.Student;
import managment.netsmartz.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student insertStudent(Student student){
        return studentRepository.save(student);
    }

    public Optional<Student> findStudent(Integer id){
        return studentRepository.findById(id);
    }

    public void deleteStudent(Integer id){
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Integer id, Student student){
        Student studentOld = studentRepository.findById(id).get();
        if(studentOld != null){
            studentOld.setName(student.getName());
            studentOld.setEmail(student.getEmail());
            studentOld.setAddress(student.getAddress());
            studentOld.setPassword(student.getPassword());
            studentOld.setCollegeName(student.getCollegeName());
            studentOld.setDob(student.getDob());
            return studentRepository.save(studentOld);
        }else{
            return null;
        }
    }

}
