package pl.coderslab.tickets.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.tickets.dao.FiltrDao;
import pl.coderslab.tickets.model.*;
import pl.coderslab.tickets.repository.DepartmentRepository;
import pl.coderslab.tickets.repository.TicketsRepository;
import pl.coderslab.tickets.repository.UsersRepository;

import javax.validation.Valid;
import java.util.List;

@Controller

public class TicketController {

    Role role;

    Priority priority;

    Department department;

    Status status;

    private final TicketsRepository ticketsRepository;
    private final UsersRepository usersRepository ;
    private final DepartmentRepository departmentRepository;
    private final FiltrDao filtrDao;


    public TicketController(TicketsRepository ticketsRepository, UsersRepository usersRepository, DepartmentRepository departmentRepository, FiltrDao filtrDao) {
        this.ticketsRepository = ticketsRepository;
        this.usersRepository = usersRepository;
        this.departmentRepository = departmentRepository;
        this.filtrDao = filtrDao;
    }







    @RequestMapping(value = "/ticket", method = RequestMethod.GET)
    public String findAll(Model model){
        List<User> userList = usersRepository.findAll();
        List<Ticket> ticketList = ticketsRepository.findAll();
        List<Department> departmentList = departmentRepository.findAll();
        model.addAttribute("filtr", new Filtr());
        model.addAttribute("department", departmentList);
        model.addAttribute("users", userList);
        model.addAttribute("tickets", ticketList);
        model.addAttribute("status", Status.values());
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
    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    public String findByUserId(@PathVariable long id){
        ticketsRepository.findById(id);
        return "redirect:/ticket";
    }
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model){
        User actual = usersRepository.findUserById(9);
        model.addAttribute("actual", actual);
        return "home";
    }
    @RequestMapping(value = "/ticketByStatus", method = RequestMethod.POST)
    public String ticketByStatus( Filtr filtr, Model model){
        List<Ticket> ticketsByStatusList = filtrDao.findAllByStatus(filtr.getStatus());
        model.addAttribute("tickets", ticketsByStatusList);
//        model.addAttribute("status", Status.values());
        return "ticket";
    }
    @RequestMapping(value = "/ticketByDepartment", method = RequestMethod.POST)
    public String ticketByDepartment(Filtr filtr, Model model){
        List<Ticket> ticketByDepartmentList = filtrDao.findByDepartment(filtr.getDepartment());
        List<Department> departmentList = departmentRepository.findAll();
        model.addAttribute("tickets",ticketByDepartmentList);
        model.addAttribute("department", departmentList);
        return "ticket";
    }
    @RequestMapping(value = "/search" , method = RequestMethod.POST)
    public String search(Filtr filtr, Model model){
        long departmentid=filtr.getDepartment().getId();
        String status = String.valueOf(filtr.getStatus());

        List<Ticket> ticketList = ticketsRepository.search(departmentid,status);
        List<Department> departmentList = departmentRepository.findAll();
        model.addAttribute("tickets", ticketList);
        model.addAttribute("department", departmentList);
        return "ticket";

    }
    }


