package pl.coderslab.tickets.model;

import java.util.Arrays;

public enum Priority {



    HIGH("HIGH"),
    MEDIUM("MEDIUM"),
    LOW("LOW");

    private final String value;

    Priority(String value){
        this.value=value;
    }

    @Override
    public String toString() {
        return value;
    }
    public static Priority priorityFromString(String s) throws IllegalArgumentException{
        return Arrays.stream(Priority.values())
                .filter(v -> v.value.equalsIgnoreCase(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown value: " + s));
    }

    public String getValue() {
        return value;
    }
}
