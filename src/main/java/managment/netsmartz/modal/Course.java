package managment.netsmartz.modal;

import jakarta.persistence.*;
import lombok.NonNull;

import java.util.List;

@Entity
@Table(name = "courses")

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer course_id;
    @NonNull
    private String name;
    @NonNull
    private String trainer_name;
    @NonNull
    private String fees;
    @NonNull
    @ManyToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<Student> studentList;

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrainer_name() {
        return trainer_name;
    }

    public void setTrainer_name(String trainer_name) {
        this.trainer_name = trainer_name;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", name='" + name + '\'' +
                ", trainer_name='" + trainer_name + '\'' +
                ", fees='" + fees + '\'' +
                ", students=" + studentList +
                '}';
    }
}
