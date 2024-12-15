package ru.system.hotel.model;

import java.time.LocalDate;

public class Passport {

    private String name;

    private String surName;

    private String series;

    private String number;

    private Address address;

    public Passport(String name, String surName, String series, String number, Address address) {
        this.name = name;
        this.surName = surName;
        this.series = series;
        this.number = number;
        this.address = address;
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

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Серия: " + series +
                ", Номер: " + number + "\n";
    }
}
