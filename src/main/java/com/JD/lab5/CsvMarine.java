package com.JD.lab5;

public class CsvMarine {
    private String name; // !=null, !="".
    private Long  coordX; // !=null.
    private Float coordY;
    private Double health; // !=null, >0.
    private Long heartCount; // >0, <=3;
    private Boolean loyal;
    private MeleeWeapon meleeWeapon; // !=null.
    private String chapterName;
    private String parentLegion; // !=null

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCoordX() {
        return coordX;
    }

    public void setCoordX(Long coordX) {
        this.coordX = coordX;
    }

    public Float getCoordY() {
        return coordY;
    }

    public void setCoordY(Double coordY) {
        this.coordY = coordY.floatValue();
    }

    public Double getHealth() {
        return health;
    }

    public void setHealth(Double health) {
        this.health = health;
    }

    public Long getHeartCount() {
        return heartCount;
    }

    public void setHeartCount(Long heartCount) {
        this.heartCount = heartCount;
    }

    public Boolean getLoyal() {
        return loyal;
    }

    public void setLoyal(Boolean loyal) {
        this.loyal = loyal;
    }

    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }

    public void setMeleeWeapon(String meleeWeapon) {
        this.meleeWeapon = MeleeWeapon.ParseMeleeWeapon(meleeWeapon);
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getParentLegion() {
        return parentLegion;
    }

    public void setParentLegion(String parentLegion) {
        this.parentLegion = parentLegion;
    }
}
