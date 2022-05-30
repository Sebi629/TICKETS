package pl.coderslab.tickets.model;

import lombok.*;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String description;
}
