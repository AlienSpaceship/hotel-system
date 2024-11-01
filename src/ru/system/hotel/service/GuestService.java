package ru.system.hotel.service;

import ru.system.hotel.model.Guest;
import ru.system.hotel.model.Passport;

import static ru.system.hotel.database.Database.guestList;

public class GuestService {

    public void addToDatabase(String name, String surName, Passport passport){
        Guest guest = new Guest(name, surName, passport);
        guestList.add(guest);
    }
}
