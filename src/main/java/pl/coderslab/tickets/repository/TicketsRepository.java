package pl.coderslab.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.tickets.model.Ticket;

public interface TicketsRepository extends JpaRepository<Ticket, Long> {
}
