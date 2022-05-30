package pl.coderslab.tickets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.tickets.model.Department;
import pl.coderslab.tickets.model.Priority;
import pl.coderslab.tickets.model.Ticket;
import pl.coderslab.tickets.model.User;
import pl.coderslab.tickets.repository.TicketsRepository;
import pl.coderslab.tickets.repository.UsersRepository;

import java.util.List;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    Priority priority;

    Department department;
    private final TicketsRepository ticketsRepository;
    private final UsersRepository usersRepository;

    public TicketController(TicketsRepository ticketsRepository, UsersRepository usersRepository) {
        this.ticketsRepository = ticketsRepository;
        this.usersRepository = usersRepository;
    }




    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String findAll(Model model){
        List<Ticket> ticketList = ticketsRepository.findAll();
        model.addAttribute("tickets", ticketList);
        return "show";
////        Date date = new Date();
////        ticketList.add(new Ticket(1, "adadaddaa",new Date()));
//        ticketList.add(new Ticket(2, "bbbbbbbbb", date));

//        User user = new User();
//        model.addAttribute("tickets",123);

    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addTicket(Model model){
        List<User> userList = usersRepository.findAll();
        model.addAttribute("users", userList);
        model.addAttribute("ticket",new Ticket());
        return "/add";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String handle(Ticket ticket){
        ticketsRepository.save(ticket);
        return "redirect:/ticket/show";
    }


}
