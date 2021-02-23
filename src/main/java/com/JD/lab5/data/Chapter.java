package com.JD.lab5.data;

import java.util.Objects;

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
        return "chapter name ='" + name + '\'' +
                ", parent legion='" + parentLegion + '\'';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentLegion() {
        return parentLegion;
    }

    public void setParentLegion(String parentLegion) {
        this.parentLegion = parentLegion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chapter chapter = (Chapter) o;
        return Objects.equals(name, chapter.name) &&
                Objects.equals(parentLegion, chapter.parentLegion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parentLegion);
    }
}
