package pl.coderslab.tickets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.tickets.model.Department;
import pl.coderslab.tickets.model.Password;
import pl.coderslab.tickets.model.Role;
import pl.coderslab.tickets.model.User;
import pl.coderslab.tickets.repository.DepartmentRepository;
import pl.coderslab.tickets.repository.UsersRepository;

import java.util.List;

@Controller
public class UserController {

    Role role;
    Department department;
    Password password;
    private final DepartmentRepository departmentRepository;
    private final UsersRepository usersRepository;
    public UserController(UsersRepository usersRepository, DepartmentRepository departmentRepository){
        this.usersRepository = usersRepository;
        this.departmentRepository = departmentRepository;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String findAll(Model model){
        List<User> userList = usersRepository.findAll();
        model.addAttribute("users", userList);
        return "user";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String adduser(Model model){
        List<Department> departmentList = departmentRepository.findAll();
        model.addAttribute("department", departmentList);
        model.addAttribute("user", new User());
        return "adduser";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String handle(User user){
        usersRepository.save(user);
        return "redirect:/user";
    }
}
