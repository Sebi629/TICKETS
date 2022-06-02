package pl.coderslab.tickets.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.tickets.model.Department;
import pl.coderslab.tickets.model.Priority;
import pl.coderslab.tickets.model.Ticket;
import pl.coderslab.tickets.model.User;
import pl.coderslab.tickets.repository.DepartmentRepository;
import pl.coderslab.tickets.repository.TicketsRepository;
import pl.coderslab.tickets.repository.UsersRepository;

import javax.validation.Valid;
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

    @RequestMapping(value = "/editticket/{id}", method = RequestMethod.GET)
    public String editTicket(@PathVariable long id, Model model) {
        List<User> userList = usersRepository.findAll();
        List<Department> departmentList = departmentRepository.findAll();
        model.addAttribute("department", departmentList);
        model.addAttribute("users", userList);
        model.addAttribute("ticket", ticketsRepository.findById(id));
        return "editticket";
    }

    @RequestMapping(value = "/editticket", method = RequestMethod.POST)
    public String editTicket(Ticket ticket) {
        ticketsRepository.save(ticket);
            return "redirect:/ticket";
        }
    @RequestMapping(value = "/pytanieticket/{id}", method = RequestMethod.GET)
    public String pytanieTicket(@PathVariable long id,Model model){
        model.addAttribute("user", ticketsRepository.findUserById(id));
        return "pytanieticket";
    }

    @RequestMapping(value = "/deleteticket/{id}", method = RequestMethod.POST)
    public String deleteTicket(@PathVariable long id){
        ticketsRepository.deleteById(id);
        return "redirect:/ticket";
    }
    }



