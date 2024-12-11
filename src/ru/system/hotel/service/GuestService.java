package ru.system.hotel.service;

import ru.system.hotel.model.Guest;
import ru.system.hotel.model.Passport;

import java.util.Iterator;

import static ru.system.hotel.database.Database.guestList;

public class GuestService {

    public void addToDatabase(String name, String surName, Passport passport) {
        Guest guest = new Guest(name, surName, passport);
        guestList.add(guest);
        System.out.println("Гость " + name + " " + surName + " добавлен.");
    }

    public void deleteFromDatabase(String name, String surName) {
        boolean success = false;
        Iterator<Guest> iterator = guestList.iterator();

        while (iterator.hasNext()) {
            Guest n = iterator.next();
            if (n.getName().equals(name) && n.getSurName().equals(surName)) {
                iterator.remove();
                success = true;
                break;
            }
        }
        if (success) {
            System.out.println("Гость " + name + " " + surName + " удален");
        } else {
            System.out.println("Такой гость не найден");
        }
    }

    public void listGuests() {
        System.out.println("Список гостей:");
        for (Guest guest : guestList) {
            System.out.print("Имя: " + guest.getName() + ", Фамилия: " + guest.getSurName() + ", Паспорт: " + guest.getPassport());
        }
    }
}
