package pl.coderslab.tickets.model;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotBlank
    private String departmentName;

    @Override
    public String toString() {
        return departmentName ;


    }
}
