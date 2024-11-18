package ru.system.hotel.controller;

import ru.system.hotel.model.Passport;
import ru.system.hotel.service.GuestService;

import java.util.Scanner;

import static ru.system.hotel.database.Database.passportList;

public class GuestController {

    GuestService service = new GuestService();
    Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("Меню: " + '\n' + "1. Добавить гостя " + '\n' + "2. Удалить гостя");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
            addGuest();
        } else if (choice == 2) {
            deleteGuest();
        } else {
            System.out.println("Неверный выбор");
            start();
        }
    }

    public void addGuest() {

        System.out.println("Введите имя: ");
        String name = sc.nextLine();
        System.out.println("Введите фамилию: ");
        String surName = sc.nextLine();
        System.out.print("Введите номер паспорта: ");
        String passportNumber = sc.nextLine();

        Passport passport = null;
        for (Passport n : passportList) {
            if (passportNumber.equals(n.getNumber())) {
                passport = n;
                break;
            }
        }
        if (passport == null) {
            System.out.println("Паспорт не найден. Добавьте сначала паспорт.");
            return;
        }
        service.addToDatabase(name, surName, passport);
    }

    public void deleteGuest() {
        System.out.println("Введите имя: ");
        String name = sc.nextLine();
        System.out.println("Введите фамилию: ");
        String surName = sc.nextLine();

        service.deleteFromDatabase(name, surName);
    }
}
