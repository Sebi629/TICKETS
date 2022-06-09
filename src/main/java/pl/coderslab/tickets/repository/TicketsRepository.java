package pl.coderslab.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.tickets.model.Ticket;

import java.util.List;
@Repository
public interface TicketsRepository extends JpaRepository<Ticket, Long> {


    Ticket findUserById(long id);

    @Query(value = "SELECT * FROM TICKETS WHERE department_id=:departmentid and status=:status", nativeQuery = true)
    List<Ticket> search(@Param("departmentid") long departmentid, @Param("status")String status);
}
