package managment.netsmartz.modal;

import jakarta.persistence.*;
import lombok.NonNull;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String username;
    @NonNull
    private String email;
    @NonNull
    private String password;

    private String token;
}
