package managment.netsmartz.modal;

import jakarta.persistence.*;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String trainer_name;
    @NonNull
    private String fees;
    @NonNull
    @OneToMany(mappedBy = "course")
    private List<Student> students;
}
