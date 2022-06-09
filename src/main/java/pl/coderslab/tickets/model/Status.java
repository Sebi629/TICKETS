package pl.coderslab.tickets.model;


import java.util.Arrays;

public enum Status {



    TODO("Todo"),
    PROGRESS("Progress"),
    DONE("Done"),
    BLOCKED("Blocked");



    private final String name;

    Status(String name){
        this.name=name();
    }
    @Override
    public String toString() {
        return name;
    }

    public static Status fromString(String s) throws IllegalArgumentException{
        return Arrays.stream(Status.values())
                .filter(v -> v.name.equalsIgnoreCase(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown value: " + s));
    }

    public String getValue() {
        return name;
    }
}



