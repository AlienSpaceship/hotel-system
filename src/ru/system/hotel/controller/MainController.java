package ru.system.hotel.controller;

import java.util.Scanner;

public class MainController {

    private GuestController guestController;
    private PassportController passportController;
    private RoomController roomController;

    public MainController(GuestController guestController, PassportController passportController, RoomController roomController) {
        this.guestController = guestController;
        this.passportController = passportController;
        this.roomController = roomController;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Кто вы?");
            System.out.println("1. Клиент");
            System.out.println("2. Админ");
            System.out.println("3. Выход");

            int choice = sc.nextInt();
            sc.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    showClientMenu();
                    break;
                case 2:
                    showAdminMenu();
                    break;
                case 3:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Ошибка выбора. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private void showClientMenu(){

        System.out.println("Меню клиента:");
        System.out.println("1. New Customer Form");
        System.out.println("2. Список комнат");
        System.out.println("3. Список гостей");
        System.out.println("4. Check out");
        System.out.println("5. Выход");

    }

    private void showAdminMenu(){

        System.out.println("Меню админа:");
        System.out.println("1. Управление гостями");
        System.out.println("2. Управление паспортами");
        System.out.println("3. Управление комнатами");
        System.out.println("4. Выход");

    }

}
