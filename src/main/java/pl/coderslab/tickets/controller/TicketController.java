package pl.coderslab.tickets.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.tickets.model.Department;
import pl.coderslab.tickets.model.Priority;
import pl.coderslab.tickets.model.Ticket;
import pl.coderslab.tickets.model.User;
import pl.coderslab.tickets.repository.DepartmentRepository;
import pl.coderslab.tickets.repository.TicketsRepository;
import pl.coderslab.tickets.repository.UsersRepository;

import java.util.List;

@Controller

public class TicketController {

    Priority priority;

    Department department;
    private final TicketsRepository ticketsRepository;
    private final UsersRepository usersRepository;
    private final DepartmentRepository departmentRepository;

    public TicketController(TicketsRepository ticketsRepository, UsersRepository usersRepository, DepartmentRepository departmentRepository) {
        this.ticketsRepository = ticketsRepository;
        this.usersRepository = usersRepository;
        this.departmentRepository = departmentRepository;
    }




    @RequestMapping(value = "/ticket", method = RequestMethod.GET)
    public String findAll(Model model){
        List<User> userList = usersRepository.findAll();
        List<Ticket> ticketList = ticketsRepository.findAll();
        model.addAttribute("users", userList);
        model.addAttribute("tickets", ticketList);
        return "ticket";
////        Date date = new Date();
////        ticketList.add(new Ticket(1, "adadaddaa",new Date()));
//        ticketList.add(new Ticket(2, "bbbbbbbbb", date));

//        User user = new User();
//        model.addAttribute("tickets",123);

    }
    @RequestMapping(value = "/addticket", method = RequestMethod.GET)
    public String addTicket(Model model){
        List<User> userList = usersRepository.findAll();
        List<Department> departmentList = departmentRepository.findAll();
        model.addAttribute("department", departmentList);
        model.addAttribute("users", userList);
        model.addAttribute("ticket",new Ticket());
        return "/addticket";
    }
    @RequestMapping(value = "/addticket", method = RequestMethod.POST)
    public String handle(Ticket ticket){
        ticketsRepository.save(ticket);
        return "redirect:/ticket";
    }
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model){
        List<Department> departmentList = departmentRepository.findAll();
        model.addAttribute("department", departmentList);
        return "home";

    }


}
