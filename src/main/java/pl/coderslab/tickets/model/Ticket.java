package pl.coderslab.tickets.model;




import com.sun.istack.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @NotNull
    private List<User> users = new ArrayList<>();

    @Column
    @NotNull
    private String description;

    @OneToOne
    @JoinColumn(name = "administration_user_id")
    private User administration_user;

    @OneToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column
    @DateTimeFormat
    private Date date;

    @Column
    @CreatedDate
    private String created;

    @Column
    @LastModifiedDate
    private String edited;

    @Column
    private boolean accepted;

    private Priority priority;

    private boolean done;

    public User getAdministration_user() {
        return administration_user;
    }

    public void setAdministration_user(User administration_user) {
        this.administration_user = administration_user;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
