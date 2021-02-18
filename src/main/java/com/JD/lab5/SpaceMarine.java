package com.JD.lab5;

import java.time.format.DateTimeFormatter;

public class SpaceMarine {
    private Long id; // !=null, >0, unique, auto-generated.
    private String name; // !=null, !="".
    private Coordinates coordinates; // !=null.
    private java.time.LocalDate creationDate; // !=null, auto-generated.
    private Double health; // !=null, >0.
    private long heartCount; // >0, <=3;
    private boolean loyal;
    private MeleeWeapon meleeWeapon; // !=null.
    private Chapter chapter; // !=null
    static private long marinesCnt;


    public SpaceMarine(String name, Coordinates coordinates, Double health, long heartCount, MeleeWeapon meleeWeapon, Chapter chapter) {
        if (name == null || name == "" || coordinates == null || health == null || health <= 0 || heartCount <= 0 || heartCount > 3 || meleeWeapon == null || chapter == null)
            System.exit(0); //Exception
        this.id = ++marinesCnt;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = java.time.LocalDate.now();
        this.health = health;
        this.heartCount = heartCount;
        this.loyal = false;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
    }
    public SpaceMarine(String name, Coordinates coordinates, Double health, long heartCount, boolean loyal, MeleeWeapon meleeWeapon, Chapter chapter) {
        this(name, coordinates, health, heartCount, meleeWeapon, chapter);
        this.loyal = loyal;
    }

    public static void setMarinesCnt(long marinesCnt) {
        SpaceMarine.marinesCnt = marinesCnt;
    }

    @Override
    public String toString() {
        return "SpaceMarine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", health=" + health +
                ", heartCount=" + heartCount +
                ", loyal=" + loyal +
                ", meleeWeapon=" + meleeWeapon +
                ", chapter=" + chapter +
                '}';
    }
}
