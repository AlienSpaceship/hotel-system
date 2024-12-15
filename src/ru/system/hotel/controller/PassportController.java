package ru.system.hotel.controller;

import ru.system.hotel.model.Address;
import ru.system.hotel.service.PassportService;


import java.util.InputMismatchException;
import java.util.Scanner;

public class PassportController {

    PassportService service;

    public PassportController(PassportService service) {
        this.service = service;
    }

    Scanner sc = new Scanner(System.in);

    public void showMenu() {
        System.out.println("Выберите действие: " + '\n' +
                "1. Добавить паспорт" + '\n' + "2. Удалить паспорт" + '\n' + "3. Список паспортов");

        int choose = 0;

        try {
            choose = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: некорректный ввод данных. Пожалуйста, попробуйте еще раз.");
            sc.nextLine();
            showMenu();
        }

        if (choose == 1) {
            addPassport();
        } else if (choose == 2) {
            deletePassport();
        } else if (choose == 3) {
            listPassport();
        } else {
            System.out.println("Ошибка выбора");
            showMenu();
        }
    }

    public void addPassport() {
        try {
            sc.nextLine();
            System.out.print("Введите имя: ");
            String name = sc.nextLine();
            System.out.print("Введите фамилию: ");
            String surName = sc.nextLine();
            System.out.print("Введите серию: ");
            String series = sc.nextLine();
            System.out.print("Введите номер: ");
            String number = sc.nextLine();
            System.out.print("Место прописки: [Страна, Город, Улица, Дом, Индекс]: ");
            Address address = addAddress();

            service.addToDatabase(name, surName, series, number, address);
            System.out.println("Паспорт успешно добавлен.");
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: некорректный ввод данных. Пожалуйста, попробуйте еще раз.");
        }
    }

    public void deletePassport() {
        sc.nextLine();
        System.out.print("Введите номер паспорта, который хотите удалить: ");
        String number = sc.nextLine();
        service.deleteFromDatabase(number);
    }

    public void listPassport() {
        System.out.println("--------------------");
        service.listPassport();
        System.out.println("--------------------");
    }

    public static Address addAddress() {

        Scanner sc = new Scanner(System.in);
        Address address = new Address(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextInt());

        return address;
    }
}
