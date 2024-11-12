package ru.system.hotel.controller;

import ru.system.hotel.model.Address;
import ru.system.hotel.service.PassportService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PassportController {

    PassportService service;

    public PassportController(PassportService service) {
        this.service = service;
    }

    public void showMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Это программа по добавлению или удалению паспорта. Выберите действие: " + '\n' +
                "1. Добавить паспорт" + '\n' + "2. Удалить паспорт");
        int choose = sc.nextInt();
        if(choose == 1){
            addPassport();
        }else if(choose == 2){
            deletePassport();
        }else {
            System.out.println("Ошибка выбора");
            showMenu();
        }
    }

    public void addPassport(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = sc.nextLine();
        System.out.print("Введите фамилию: ");
        String surName = sc.nextLine();
        System.out.print("Введите серию: ");
        String series = sc.nextLine();
        System.out.print("Введите номер: ");
        String number = sc.nextLine();
        System.out.print("Введите дату выдачи: ");
        LocalDate dateOfIssue = addDate();
        System.out.print("Кем выдано: ");
        String issuedByWhom = sc.nextLine();
        System.out.print("Место прописки: ");
        Address address = addAddress();

        service.addToDatabase(name, surName, series, number, dateOfIssue, issuedByWhom, address);
    }

    public void deletePassport(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите номер паспорта, который хотите удалить: ");
        String number = sc.nextLine();
        service.deleteFromDatabase(number);
    }

    public static LocalDate addDate() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a date [dd. MMM. yyyy]: ");
        String str = scan.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd. MMM. yyyy");
        return LocalDate.parse(str, dtf);
    }

    public static Address addAddress() {

        Scanner sc = new Scanner(System.in);
        Address address = new Address(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextInt());

        return address;
    }
}
