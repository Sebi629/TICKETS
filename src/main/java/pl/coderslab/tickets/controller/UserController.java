package pl.coderslab.tickets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.tickets.model.Department;

import pl.coderslab.tickets.model.Role;
import pl.coderslab.tickets.model.User;
import pl.coderslab.tickets.repository.DepartmentRepository;
import pl.coderslab.tickets.repository.RoleRepository;
import pl.coderslab.tickets.repository.UsersRepository;

import java.util.List;

@Controller
public class UserController {


    Role role;
    Department department;

    private final DepartmentRepository departmentRepository;
    private final UsersRepository usersRepository;
    private  final RoleRepository roleRepository;
    public UserController(UsersRepository usersRepository, DepartmentRepository departmentRepository, RoleRepository roleRepository){
        this.usersRepository = usersRepository;
        this.departmentRepository = departmentRepository;
        this.roleRepository = roleRepository;
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
        List<Role> roleList = roleRepository.findAll();
        model.addAttribute("role", roleList);
        model.addAttribute("department", departmentList);
        model.addAttribute("user", new User());
        return "adduser";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String handle(User user){
        usersRepository.save(user);
        return "redirect:/user";
    }
    @RequestMapping(value = "/edituser/{id}", method = RequestMethod.GET)
    public String editUser(@PathVariable long id,Model model){
        List<Department> departmentList = departmentRepository.findAll();
        List<Role> roleList = roleRepository.findAll();
        model.addAttribute("role", roleList);
        model.addAttribute("department", departmentList);
        model.addAttribute("user", usersRepository.findById(id));
        return "edituser";
    }
    @RequestMapping(value = "/edituser", method = RequestMethod.POST)
    public String handleEditUser(User user){
        usersRepository.save(user);
        return "redirect:/user";
    }
    @RequestMapping(value = "/pytanieuser/{id}", method = RequestMethod.GET)
    public String pytanieUser(@PathVariable long id,Model model){
        model.addAttribute("user", usersRepository.findUserById(id));
        return "pytanieuser";
    }


    @RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.POST)
    public String deleteUser(@PathVariable long id){
        usersRepository.deleteById(id);
        return "redirect:/user";
    }
}
