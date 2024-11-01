package ru.system.hotel.service;
import ru.system.hotel.model.Address;
import ru.system.hotel.model.Passport;
import java.time.LocalDate;
import java.util.ArrayList;

import static ru.system.hotel.database.Database.passportList;

public class PassportService {

    public boolean addToDatabase(String name, String surName, String series, String number, LocalDate dateOfIssue,
                              String issuedByWhom, Address address) {
        if(name == null  || surName == null || series == null || number == null || dateOfIssue == null ||
                issuedByWhom == null || address == null){
            System.out.println("Ошибка: Поле не заполнено");
            return false;
        }
        try {
            Passport passport = new Passport(name, surName, series, number, dateOfIssue, issuedByWhom, address);
            passportList.add(passport);
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
            System.out.println("Ошибка при добавлении паспорта: " + ex.getMessage());
            return false;
        }

    }

    public boolean deleteFromDatabase(String number){
        for (Passport passport : passportList){
            if (passport.getNumber().equals(number)){
                passportList.remove(passport);
                System.out.println("Паспорт удален: " + number);
                return true;
            }
        }
        System.out.println("Ошибка: Паспорт с номером " + number + " не найден.");
        return false; // Паспорт с таким номером не найден
    }

//    public boolean editInTheDatabase(String number) {
//        for (Passport passport : passportList) {
//            if (passport.getNumber().equals(number)) {
//                passport.setName();
//                passport.setAddress();
//                System.out.println("Паспорт изменен: " + number);
//                return true;
//            } else {
//                System.out.println("Ошибка: Паспорт с номером " + number + " не найден.");
//                return false; // Неуспех
//            }
//        }
//        return false;
//    }


}

