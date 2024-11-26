package ru.system.hotel.service;

import ru.system.hotel.model.Guest;
import ru.system.hotel.model.Passport;

import static ru.system.hotel.database.Database.guestList;

public class GuestService {

    public void addToDatabase(String name, String surName, Passport passport){
        Guest guest = new Guest(name, surName, passport);
        guestList.add(guest);
        System.out.println("Гость " + name + " " + surName + " добавлен.");
    }

    public void deleteFromDatabase(String name, String surName) {
        for (Guest guest : guestList) {
            if (guest.getName().equals(name) && guest.getSurName().equals(surName)) {
                guestList.remove(guest);
                System.out.println("Гость удален: " + name + " " + surName);
                return;
            }
        }
        System.out.println("Ошибка: Гость " + name + " " + surName + " не найден.");
    }

    public void listGuests() {
        System.out.println("Список гостей:");
        for (Guest guest : guestList) {
            System.out.print("Имя: " + guest.getName() + ", Фамилия: " + guest.getSurName() + ", Паспорт: " + guest.getPassport());
        }
    }

}
