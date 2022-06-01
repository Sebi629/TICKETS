package pl.coderslab.tickets.model;

import com.sun.istack.NotNull;
import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 256)
    @NotBlank
    private String firstName;

    @Column(length = 256)
    @NotNull
    private String lastName;

    @Column
    @NotNull
    @Email
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "password_id")
    private Password password;

    private Role role;

    private Position position;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public User(long id, String firstName, String lastName, String email, Password password, Role role, Position position, Department department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.position = position;
        this.department = department;
    }
}

