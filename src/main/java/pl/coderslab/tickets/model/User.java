package pl.coderslab.tickets.model;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
@Getter
@Setter

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
    private String email;

    @OneToOne
    @JoinColumn(name = "password_id")
    private Password pasword;

    public Password getPasword() {
        return pasword;
    }

    public void setPasword(Password pasword) {
        this.pasword = pasword;
    }
    private Privileges privileges;

    private Position position;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public User() {
    }

}

