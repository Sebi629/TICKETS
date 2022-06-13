package pl.coderslab.tickets.model;




import com.sun.istack.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


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
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate date;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime created;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    @Column
    @LastModifiedDate
    private LocalDateTime edited;

    @PreUpdate
    public void preUpdate() {
        edited = LocalDateTime.now();
    }

    @Column
    private boolean accepted;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}
