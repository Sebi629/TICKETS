package pl.coderslab.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.tickets.model.Ticket;

import java.util.List;
@Repository
public interface TicketsRepository extends JpaRepository<Ticket, Long> {

       Ticket getTicketById(Long id);

       Ticket save(Ticket ticket);



//       Ticket save();
//       List<Ticket> getALL();

}
