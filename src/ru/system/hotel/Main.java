package ru.system.hotel;

import ru.system.hotel.controller.PassportController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //       PassportService passportService = new PassportService();
//        Address address1 = new Address("Russia", "Moscow", "Arbat", 35, 119002);
//        Address address2 = new Address("Russia", "Novgorod", "Pushkina", 2, 411200);
//
//        passportService.addToDatabase("Ivan", "Ivanov", "1234", "34444",
//                LocalDate.of(2023, 10, 20), "Отделение УФМС", address1);
//
//        passportService.addToDatabase("Semen", "Orlov", "3214", "11122",
//                LocalDate.of(2022, 5, 11), "Отделение УФМС", address2);
//      System.out.println((passportList.stream().filter(x -> x.getNumber().equals("34444")).toList()));
        Scanner sc = new Scanner(System.in);
        PassportController passportController = new PassportController();
        System.out.println("Добавление нового пасспорта: Кнопка 1");
        String input = sc.nextLine();
        if (input.equals("1")) {
            passportController.addToDatabase();
        }
    }
}


// Hotel, Room, Guest, Reservation, CheckIn, CheckOut, Payment

