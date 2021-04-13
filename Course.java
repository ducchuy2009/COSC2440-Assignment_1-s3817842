package com.company;

public class Course {
    private String id;
    private String name;
    private int noCredits;

    public Course(String id, String name, int noCredits) {
        super();
        this.id = id;
        this.name = name;
        this.noCredits = noCredits;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNoCredits() {
        return noCredits;
    }
}

