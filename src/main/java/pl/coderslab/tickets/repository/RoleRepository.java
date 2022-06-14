package pl.coderslab.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.tickets.model.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {




    Role findRoleByName(String name);

}
