package ru.system.hotel.service;

import ru.system.hotel.model.Address;
import ru.system.hotel.model.Passport;

import java.time.LocalDate;

import static ru.system.hotel.database.Database.passportList;

public class PassportService {

    public void addToDatabase(String name, String surName, String series, String number, LocalDate dateOfIssue,
                              String issuedByWhom, Address address) {
        Passport passport = new Passport(name, surName, series, number, dateOfIssue, issuedByWhom, address);
        passportList.add(passport);
        System.out.println("Паспорт с номером " + number + " добавлен.");
    }

    public void deleteFromDatabase(String number) {
        for (Passport n : passportList) {
            if (n.getNumber().equals(number)) {
                passportList.remove(n);
                System.out.println("Паспорт удален: " + number);
                return;
            }
        }
        System.out.println("Ошибка: Паспорт с номером " + number + " не найден.");

    }
}
