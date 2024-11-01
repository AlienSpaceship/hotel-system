package ru.system.hotel.controller;

import ru.system.hotel.model.Address;
import ru.system.hotel.service.PassportService;

import java.time.LocalDate;

public class PassportController {

    PassportService passportService = new PassportService();

    public boolean addToDatabase(String name, String surName, String series, String number, LocalDate dateOfIssue,
                                 String issuedByWhom, Address address){
        boolean result = passportService.addToDatabase(name, surName, series, number, dateOfIssue, issuedByWhom, address);
        System.out.println("Результат по добавлению в БД: " + result);
        return result;
    }
}
