package ru.system.hotel.controller;

import ru.system.hotel.model.Address;
import ru.system.hotel.model.Passport;
import ru.system.hotel.service.GuestService;

import java.util.InputMismatchException;
import java.util.Scanner;

import static ru.system.hotel.database.Database.passportList;

public class GuestController {

    GuestService service = new GuestService();
    Scanner sc = new Scanner(System.in);

    public void showMenu() {

        System.out.println("Меню: " + '\n' + "1. Добавить гостя " + '\n' + "2. Удалить гостя" + '\n' + "3. Список гостей" + '\n' + "4. Выход");
        int choice = 0;
        try {
            choice = sc.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Ошибка: некорректный ввод данных. Пожалуйста, попробуйте еще раз.");
            sc.nextLine();
            showMenu();
        }

        sc.nextLine();
        if (choice == 1) {
            addGuest();
        } else if (choice == 2) {
            deleteGuest();
        } else if (choice == 3) {
            listGuests();
        } else if (choice == 4) {
            showMenu();
        } else {
            System.out.println("Неверный выбор");
        }

    }

    public void addGuest() {
        try {
            System.out.println("Введите имя: ");
            String name = sc.nextLine();

            System.out.println("Введите фамилию: ");
            String surName = sc.nextLine();

            System.out.print("Введите серию паспорта: ");
            String passportSeries = sc.nextLine();

            System.out.print("Введите номер паспорта: ");
            String passportNumber = sc.nextLine();

            System.out.print("Место прописки: [Страна, Город, Улица, Дом, Индекс]: ");
            String country = sc.nextLine();
            String city = sc.nextLine();
            String street = sc.nextLine();
            int numberHome = sc.nextInt();
            int index = sc.nextInt();
            sc.nextLine();

            //Проверка существования паспорта
            Passport passport = passportList
                    .stream()
                    .filter(x -> x.getNumber().equals(passportNumber) && x.getSeries().equals(passportSeries))
                    .findFirst()
                    .orElse(null);

            if (passport == null) {
                passport = new Passport(name, surName, passportSeries, passportNumber,
                        new Address(country, city, street, numberHome, index));
                passportList.add(passport);
            }

            service.addToDatabase(name, surName, passport);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: некорректный ввод данных. Пожалуйста, попробуйте еще раз.");
            sc.nextLine();
        }
    }

    public void deleteGuest() {
        System.out.println("Введите имя: ");
        String name = sc.nextLine();
        System.out.println("Введите фамилию: ");
        String surName = sc.nextLine();

        service.deleteFromDatabase(name, surName);
    }

    public void listGuests(){
        System.out.println("--------------------");
        service.listGuests();
        System.out.println("--------------------");
    }
}
