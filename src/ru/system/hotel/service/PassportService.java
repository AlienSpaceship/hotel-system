package ru.system.hotel.service;

import ru.system.hotel.model.Address;
import ru.system.hotel.model.Passport;

import java.time.LocalDate;
import java.util.Iterator;

import static ru.system.hotel.database.Database.passportList;

public class PassportService {

    public void addToDatabase(String name, String surName, String series, String number, Address address) {
        Passport passport = new Passport(name, surName, series, number, address);
        passportList.add(passport);
        System.out.println("Паспорт с номером " + number + " добавлен.");
    }

    public void deleteFromDatabase(String number) {
        boolean success = false;
        Iterator<Passport> iterator = passportList.iterator();

        while (iterator.hasNext()) {
            Passport n = iterator.next();
            if (n.getNumber().equals(number)) {
                iterator.remove();
                success = true;
                break;
            }
        }
        if (success) {
            System.out.println("Паспорт с номером " + number + " удален");
        } else {
            System.out.println("Ошибка: Паспорт с номером " + number + " не найден.");
        }
    }

    public void listPassport() {
        System.out.println("Список паспортов:");
        for (Passport passport : passportList) {
            System.out.println("Имя: " + passport.getName() + ", Фамилия: " + passport.getSurName() +
                    ", Серия: " + passport.getSeries() + ", Номер: " + passport.getNumber() +
                    ", Адрес: " + passport.getAddress());
        }
    }

}
