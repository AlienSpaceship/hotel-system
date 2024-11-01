package ru.system.hotel.model;

public class Guest {

    private String name;

    private String surName;

    private Passport passport;

    public Guest(String name, String surName, Passport passport) {
        this.name = name;
        this.surName = surName;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
