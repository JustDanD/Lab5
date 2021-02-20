package com.JD.lab5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Stack;

public class SpaceMarine implements Comparable<SpaceMarine> {
    private Long id; // !=null, >0, unique, auto-generated.
    private String name; // !=null, !="".
    private Coordinates coordinates; // !=null.
    private LocalDate creationDate; // !=null, auto-generated.
    private Double health; // !=null, >0.
    private long heartCount; // >0, <=3;
    private boolean loyal;
    private MeleeWeapon meleeWeapon; // !=null.
    private Chapter chapter; // !=null
    static private Stack<Long> idStack;
    public SpaceMarine() {
    }

    public SpaceMarine(String name, Coordinates coordinates, Double health, long heartCount, MeleeWeapon meleeWeapon, Chapter chapter) {
        if (name == null || name.equals("") || coordinates == null || health == null || health <= 0 || heartCount <= 0 || heartCount > 3 || meleeWeapon == null || chapter == null)
            System.exit(0); //Exception
        if (idStack == null)
           initIdStack();
        this.id = idStack.lastElement() + 1;
        idStack.push(this.id);
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDate.now();
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (idStack == null)
            initIdStack();
        if (!idStack.contains(id))
        {
            this.id = id;
            idStack.push(id);
        }
        else
        {
            this.id = idStack.lastElement() + 1;
            idStack.push(this.id);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public void setCoordinatesX(Long coordinates) {
        this.coordinates.setX(coordinates);
    }
    public void setCoordinatesY(Float coordinates) {
        this.coordinates.setY(coordinates);
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = new java.sql.Date(creationDate.getTime()).toLocalDate();
    }

    public Double getHealth() {
        return health;
    }

    public void setHealth(Double health) {
        this.health = health;
    }

    public long getHeartCount() {
        return heartCount;
    }

    public void setHeartCount(long heartCount) {
        this.heartCount = heartCount;
    }

    public boolean isLoyal() {
        return loyal;
    }

    public void setLoyal(boolean loyal) {
        this.loyal = loyal;
    }

    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }

    public void setMeleeWeapon(String meleeWeapon) {
        this.meleeWeapon = MeleeWeapon.ParseMeleeWeapon(meleeWeapon);
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public void setChapterName(String chapter) {
        this.chapter.setName(chapter);
    }

    public void setLegion(String Legion) {
        this.chapter.setParentLegion(Legion);
    }
    private static void initIdStack() {
        idStack = new Stack<Long>();
        idStack.push(0L);
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

    @Override
    public int compareTo(SpaceMarine spaceMarine) {
        return coordinates.compareTo(spaceMarine.coordinates);
    }
}
