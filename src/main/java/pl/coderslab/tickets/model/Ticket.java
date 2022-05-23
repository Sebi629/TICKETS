package pl.coderslab.tickets.model;




import com.sun.istack.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private String description;

    @Column
    @NotNull
    private String department;

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
    private boolean admin;
}
