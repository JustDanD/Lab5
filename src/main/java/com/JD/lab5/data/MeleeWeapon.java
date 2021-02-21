package com.JD.lab5.data;

public enum MeleeWeapon {
    POWER_SWORD,
    CHAIN_AXE,
    POWER_BLADE,
    POWER_FIST;

    public static  MeleeWeapon parseMeleeWeapon( String input) {
        switch (input) {
            default:
                return null;
            case "POWER_SWORD":
                return POWER_SWORD;
            case "CHAIN_AXE":
                return CHAIN_AXE;
            case "POWER_BLADE":
                return POWER_BLADE;
            case "POWER_FIST":
                return POWER_FIST;
        }
    }
}
