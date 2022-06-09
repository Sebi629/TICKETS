package pl.coderslab.tickets.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.tickets.model.Department;
import pl.coderslab.tickets.model.Filtr;
import pl.coderslab.tickets.model.Status;
import pl.coderslab.tickets.model.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class FiltrDao {
@PersistenceContext
    EntityManager entityManager;

    public List<Ticket> findAllByStatus(Status status) {
        return entityManager
                .createQuery("SELECT t from Ticket t where t.status = :status")
                .setParameter("status", status)
                .getResultList();
    }
    public List<Ticket> findByDepartment(Department department){

//        Query query = entityManager.createQuery( "SELECT t from Ticket t where t.department = :department");
//        if(department==null){
//            entityManager.createQuery("SELECT t from Ticket t");
//        };

        return entityManager
                .createQuery("SELECT t from Ticket t where t.department = :department")
                .setParameter("department", department)
                .getResultList();
//        return query.getResultList();
    }
//    public List<Ticket> serchTickets(Filtr filtr){
//        Query query = entityManager.createQuery("SELECT t from Ticket t where t.department = :department");
//        if(filtr.getDepartment()!=null){
//
//        }


}
