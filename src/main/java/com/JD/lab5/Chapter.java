package com.JD.lab5;

public class Chapter {
    private String name; //!= null, != ""
    private String parentLegion;

    public Chapter(String name, String parentLegion) {
        if (name == null || name == "")
            System.exit(0); //Exception
        this.name = name;
        this.parentLegion = parentLegion;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "name='" + name + '\'' +
                ", parentLegion='" + parentLegion + '\'' +
                '}';
    }
}
