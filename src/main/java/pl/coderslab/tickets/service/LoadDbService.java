package pl.coderslab.tickets.service;

import org.springframework.stereotype.Service;
import pl.coderslab.tickets.model.*;
import pl.coderslab.tickets.repository.DepartmentRepository;
import pl.coderslab.tickets.repository.RoleRepository;
import pl.coderslab.tickets.repository.TicketsRepository;
import pl.coderslab.tickets.repository.UsersRepository;

import java.time.LocalDate;

@Service
public class LoadDbService {

    private DepartmentRepository departmentRepository;
    private UsersRepository usersRepository;
    private TicketsRepository ticketsRepository;
    private RoleRepository roleRepository;

    public LoadDbService(DepartmentRepository departmentRepository, UsersRepository usersRepository, TicketsRepository ticketsRepository, RoleRepository roleRepository) {
        this.departmentRepository = departmentRepository;
        this.usersRepository = usersRepository;
        this.ticketsRepository = ticketsRepository;
        this.roleRepository = roleRepository;
    }
    public void loadDb(){

        //department
        Department department1 = new Department();
        department1.setDepartmentName("speed");
        departmentRepository.save(department1);
        Department department2 = new Department();
        department2.setDepartmentName("teamwork");
        departmentRepository.save(department2);
        Department department3 = new Department();
        department3.setDepartmentName("provocation");
        departmentRepository.save(department3);
        Department department4 = new Department();
        department4.setDepartmentName("administration");
        departmentRepository.save(department4);

        //role
        Role role1 = new Role();
        role1.setName("USER");
        roleRepository.save(role1);

        Role role2 = new Role();
        role2.setName("ADMIN");
        roleRepository.save(role2);

        //user
        User user1 = new User();
        user1.setFirstName("Przemysław");
        user1.setLastName("Woźniak");
        user1.setEmail("przemyslaw.wozniak@company.com");
        user1.setPassword("12345");
        user1.setRole(roleRepository.findRoleByName("USER"));
        user1.setPosition(Position.valueOf("USER"));
        user1.setDepartment(department1);
        usersRepository.save(user1);

        User user2 = new User();
        user2.setFirstName("Ksawery");
        user2.setLastName("Kamiński");
        user2.setEmail("ksawery.kaminski@company.com");
        user2.setPassword("12345");
        user2.setRole(roleRepository.findRoleByName("ADMIN"));
        user2.setPosition(Position.valueOf("USER"));
        user2.setDepartment(department2);
        usersRepository.save(user2);

        User user3 = new User();
        user3.setFirstName("Agata");
        user3.setLastName("Pawlak");
        user3.setEmail("agatapawlak@company.com");
        user3.setPassword("12345");
        user3.setRole(roleRepository.findRoleByName("ADMIN"));
        user3.setPosition(Position.valueOf("DIRECTOR"));
        user3.setDepartment(department3);
        usersRepository.save(user3);

        User user4 = new User();
        user4.setFirstName("Lara");
        user4.setLastName("Urbańska");
        user4.setEmail("laraurbanska@company.com");
        user4.setPassword("12345");
        user4.setRole(roleRepository.findRoleByName("USER"));
        user4.setPosition(Position.valueOf("MANAGER"));
        user4.setDepartment(department4);
        usersRepository.save(user4);

        //tickets
        Ticket ticket1 = new Ticket();
        ticket1.setUser(user1);
        ticket1.setDescription("zadanie 1");
        ticket1.setDepartment(user1.getDepartment());
        ticket1.setDate(LocalDate.ofYearDay(2022,168));
        ticket1.setPriority(Priority.priorityFromString("HIGH"));
        ticket1.setStatus(Status.fromString("DONE"));
        ticketsRepository.save(ticket1);

        Ticket ticket2 = new Ticket();
        ticket2.setUser(user1);
        ticket2.setDescription("zadanie 2");
        ticket2.setDepartment(user1.getDepartment());
        ticket2.setDate(LocalDate.ofYearDay(2022,165));
        ticket2.setPriority(Priority.priorityFromString("MEDIUM"));
        ticket2.setStatus(Status.fromString("TODO"));
        ticketsRepository.save(ticket2);

        Ticket ticket3 = new Ticket();
        ticket3.setUser(user1);
        ticket3.setDescription("zadanie 3");
        ticket3.setDepartment(user1.getDepartment());
        ticket3.setDate(LocalDate.ofYearDay(2022,164));
        ticket3.setPriority(Priority.priorityFromString("LOW"));
        ticket3.setStatus(Status.fromString("PROGRESS"));
        ticketsRepository.save(ticket3);

        Ticket ticket4 = new Ticket();
        ticket4.setUser(user2);
        ticket4.setDescription("zadanie 1");
        ticket4.setDepartment(user2.getDepartment());
        ticket4.setDate(LocalDate.ofYearDay(2022,166));
        ticket4.setPriority(Priority.priorityFromString("HIGH"));
        ticket4.setStatus(Status.fromString("DONE"));
        ticketsRepository.save(ticket4);

        Ticket ticket5 = new Ticket();
        ticket5.setUser(user2);
        ticket5.setDescription("zadanie 2");
        ticket5.setDepartment(user2.getDepartment());
        ticket5.setDate(LocalDate.ofYearDay(2022,167));
        ticket5.setPriority(Priority.priorityFromString("MEDIUM"));
        ticket5.setStatus(Status.fromString("TODO"));
        ticketsRepository.save(ticket5);

        Ticket ticket6 = new Ticket();
        ticket6.setUser(user2);
        ticket6.setDescription("zadanie 3");
        ticket6.setDepartment(user2.getDepartment());
        ticket6.setDate(LocalDate.ofYearDay(2022,168));
        ticket6.setPriority(Priority.priorityFromString("LOW"));
        ticket6.setStatus(Status.fromString("PROGRESS"));
        ticketsRepository.save(ticket6);

        Ticket ticket7 = new Ticket();
        ticket7.setUser(user3);
        ticket7.setDescription("zadanie 1");
        ticket7.setDepartment(user3.getDepartment());
        ticket7.setDate(LocalDate.ofYearDay(2022,163));
        ticket7.setPriority(Priority.priorityFromString("HIGH"));
        ticket7.setStatus(Status.fromString("DONE"));
        ticketsRepository.save(ticket7);

        Ticket ticket8 = new Ticket();
        ticket8.setUser(user3);
        ticket8.setDescription("zadanie 2");
        ticket8.setDepartment(user3.getDepartment());
        ticket8.setDate(LocalDate.ofYearDay(2022,164));
        ticket8.setPriority(Priority.priorityFromString("MEDIUM"));
        ticket8.setStatus(Status.fromString("TODO"));
        ticketsRepository.save(ticket8);

        Ticket ticket9 = new Ticket();
        ticket9.setUser(user3);
        ticket9.setDescription("zadanie 3");
        ticket9.setDepartment(user3.getDepartment());
        ticket9.setDate(LocalDate.ofYearDay(2022,165));
        ticket9.setPriority(Priority.priorityFromString("LOW"));
        ticket9.setStatus(Status.fromString("PROGRESS"));
        ticketsRepository.save(ticket9);

        Ticket ticket10 = new Ticket();
        ticket10.setUser(user4);
        ticket10.setDescription("zadanie 1");
        ticket10.setDepartment(user4.getDepartment());
        ticket10.setDate(LocalDate.ofYearDay(2022,164));
        ticket10.setPriority(Priority.priorityFromString("HIGH"));
        ticket10.setStatus(Status.fromString("DONE"));
        ticketsRepository.save(ticket10);

        Ticket ticket11 = new Ticket();
        ticket11.setUser(user4);
        ticket11.setDescription("zadanie 2");
        ticket11.setDepartment(user4.getDepartment());
        ticket11.setDate(LocalDate.ofYearDay(2022,170));
        ticket11.setPriority(Priority.priorityFromString("MEDIUM"));
        ticket11.setStatus(Status.fromString("TODO"));
        ticketsRepository.save(ticket11);

        Ticket ticket12 = new Ticket();
        ticket12.setUser(user4);
        ticket12.setDescription("zadanie 3");
        ticket12.setDepartment(user4.getDepartment());
        ticket12.setDate(LocalDate.ofYearDay(2022,175));
        ticket12.setPriority(Priority.priorityFromString("LOW"));
        ticket12.setStatus(Status.fromString("PROGRESS"));
        ticketsRepository.save(ticket12);
    }
}
