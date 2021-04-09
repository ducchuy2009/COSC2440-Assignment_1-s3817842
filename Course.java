package com.company;

import java.util.ArrayList;

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

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", noCredits=" + noCredits +
                '}';
    }
}

