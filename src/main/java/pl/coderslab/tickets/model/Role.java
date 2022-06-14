package pl.coderslab.tickets.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;



    @Entity
    @Table
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode


    public class Role {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(unique = true)
        private String name;

        @OneToMany(mappedBy = "role")
        private List<User> users;

        @Override
        public String toString() {
            return  name;
        }
    }
