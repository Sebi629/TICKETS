package pl.coderslab.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.tickets.model.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
