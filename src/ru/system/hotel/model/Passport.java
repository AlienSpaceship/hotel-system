package ru.system.hotel.model;

import java.time.LocalDate;

public class Passport {

    private String name;

    private String surName;

    private String series;

    private String number;

    private LocalDate dateOfIssue;

    private String issuedByWhom;

    private Address address;

    public Passport(String name, String surName, String series, String number, LocalDate dateOfIssue,
                    String issuedByWhom, Address address) {
        this.name = name;
        this.surName = surName;
        this.series = series;
        this.number = number;
        this.dateOfIssue = dateOfIssue;
        this.issuedByWhom = issuedByWhom;
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

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getIssuedByWhom() {
        return issuedByWhom;
    }

    public void setIssuedByWhom(String issuedByWhom) {
        this.issuedByWhom = issuedByWhom;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", series='" + series + '\'' +
                ", number='" + number + '\'' +
                ", dateOfIssue=" + dateOfIssue +
                ", issuedByWhom='" + issuedByWhom + '\'' +
                ", address=" + address +
                '}';
    }
}
