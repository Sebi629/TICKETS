package pl.coderslab.tickets.service;

import org.springframework.stereotype.Service;
import pl.coderslab.tickets.model.Filtr;
import pl.coderslab.tickets.model.Ticket;
import pl.coderslab.tickets.repository.TicketsRepository;

import java.util.List;

@Service
public class TicketService {



    private final TicketsRepository ticketsRepository;

    public TicketService(TicketsRepository ticketsRepository) {
        this.ticketsRepository = ticketsRepository;
    }

    public List<Ticket> search(Filtr filtr){
        String departmentid;
        String status;
        if(filtr.getDepartment()==null){
            departmentid="";
        }else{
            departmentid=String.valueOf(filtr.getDepartment().getId());
        }
        if(filtr.getStatus()==null){
            status="";
        }else{
            status=String.valueOf(filtr.getStatus());
        }
        List<Ticket> ticketList = ticketsRepository.search(departmentid,status);
        return ticketList;
    }
}
