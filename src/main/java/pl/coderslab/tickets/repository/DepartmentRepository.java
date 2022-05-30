package pl.coderslab.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.tickets.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
