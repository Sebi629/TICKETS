package pl.coderslab.tickets.model;

import com.sun.istack.NotNull;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 256)
    @NotNull                   // czemu nie mogę znaleźć @NotBlank
    private String firstName;

    @Column(length = 256)
    @NotNull
    private String lastName;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private String paswoord;

    @Column
    @NotNull
    private String department;

    @Column
    private boolean admin;
}
