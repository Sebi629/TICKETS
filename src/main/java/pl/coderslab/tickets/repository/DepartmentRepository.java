package pl.coderslab.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.tickets.model.Department;
import pl.coderslab.tickets.model.Ticket;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
