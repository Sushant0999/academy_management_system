package managment.netsmartz.modal;

import jakarta.persistence.*;
import lombok.NonNull;

import java.util.Date;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private String address;
    @NonNull
    private Date dob;
    @NonNull
    private String collegeName;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "course_id")
    private String course;

    private String token;
}
