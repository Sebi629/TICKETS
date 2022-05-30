package pl.coderslab.tickets.model;




import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tickets")
@Setter
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor

public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    @NotNull
    private User user;

    @Column
    @NotNull
    private String description;

   @ManyToOne
    @JoinColumn(name = "assigned_user_id")
    private User assingnedUser;

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




}
