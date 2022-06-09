package pl.coderslab.tickets.model;

import javax.persistence.ManyToOne;

public class Filtr {

    public Status status;
    public Department department;
//    public Priority priority;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

//    public Priority getPriority() {
//        return priority;
//    }
//
//    public void setPriority(Priority priority) {
//        this.priority = priority;
//    }
}
