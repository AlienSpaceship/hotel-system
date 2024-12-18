package ru.system.hotel.model;

public class Address {

    private String country;

    private String city;

    private String street;

    private int numberHome;

    private int index;

    public Address(String country, String city, String street, int numberHome, int index) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.numberHome = numberHome;
        this.index = index;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumberHome() {
        return numberHome;
    }

    public void setNumberHome(int numberHome) {
        this.numberHome = numberHome;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return country + ", " + city + ", " + street + " " + numberHome + ", " + index ;
    }
}

