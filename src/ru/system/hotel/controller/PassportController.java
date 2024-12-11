package ru.system.hotel.controller;

import ru.system.hotel.model.Address;
import ru.system.hotel.service.PassportService;

import java.time.LocalDate;

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
                "1. Добавить паспорт" + '\n' + "2. Удалить паспорт");

        int choose = 0;

        try {
            choose = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Неверный ввод");
            sc.nextLine();
            showMenu();
        }

        if (choose == 1) {
            addPassport();
        } else if (choose == 2) {
            deletePassport();
        } else {
            System.out.println("Ошибка выбора");
            showMenu();
        }
    }

    public void addPassport() {
        sc.nextLine();
        System.out.print("Введите имя: ");
        String name = sc.nextLine();
        System.out.print("Введите фамилию: ");
        String surName = sc.nextLine();
        System.out.print("Введите серию: ");
        String series = sc.nextLine();
        System.out.print("Введите номер: ");
        String number = sc.nextLine();
        System.out.print("Введите дату выдачи: ");
        LocalDate dateOfIssue = addDate(sc);
        sc.nextLine();
        System.out.print("Кем выдано: ");
        String issuedByWhom = sc.nextLine();
        System.out.print("Место прописки: ");
        Address address = addAddress();

        service.addToDatabase(name, surName, series, number, dateOfIssue, issuedByWhom, address);
    }

    public void deletePassport() {
        sc.nextLine();
        System.out.print("Введите номер паспорта, который хотите удалить: ");
        String number = sc.nextLine();
        service.deleteFromDatabase(number);
    }

    public static LocalDate addDate(Scanner scanner) {
        return LocalDate.parse(scanner.next());
    }

    public static Address addAddress() {

        Scanner sc = new Scanner(System.in);
        Address address = new Address(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextInt());

        return address;
    }
}
