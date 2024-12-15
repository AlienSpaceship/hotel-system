package ru.system.hotel.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainController {

    private GuestController guestController;
    private PassportController passportController;
    private RoomController roomController;

    public MainController() {
    }

    public MainController(GuestController guestController, PassportController passportController, RoomController roomController) {
        this.guestController = guestController;
        this.passportController = passportController;
        this.roomController = roomController;
    }

    Scanner sc = new Scanner(System.in);

    public void start() {

        while (true) {
            System.out.println("Кто вы?");
            System.out.println("1. Клиент");
            System.out.println("2. Админ");
            System.out.println("3. Выход");

            int choice = 0;

            try {
                choice = sc.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Ошибка выбора. Пожалуйста, попробуйте снова.");
                sc.nextLine();
                start();
            }

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

    private void showClientMenu() {

        System.out.println("Меню клиента:");
        System.out.println("1. Добавить гостя");
        System.out.println("2. Список комнат");
        System.out.println("3. Список гостей");
        System.out.println("4. Назад");
        int choice = 0;
        try {
            choice = sc.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Ошибка выбора. Пожалуйста, попробуйте снова.");
            sc.nextLine();
            showClientMenu();
        }

        sc.nextLine();
        switch (choice) {
            case 1:
                guestController.addGuest();
                break;
            case 2:
                roomController.listRoom();
                break;
            case 3:
                guestController.listGuests();
                break;
            case 4:
                return;
            default:
                System.out.println("Ошибка выбора. Пожалуйста, попробуйте снова.");

        }
    }

    private void showAdminMenu() {

        System.out.println("Меню админа:");
        System.out.println("1. Управление гостями");
        System.out.println("2. Управление паспортами");
        System.out.println("3. Управление комнатами");
        System.out.println("4. Назад");
        int choice = 0;
        try {
            choice = sc.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Ошибка выбора. Пожалуйста, попробуйте снова.");
            sc.nextLine();
            showAdminMenu();
        }

        sc.nextLine();
        switch (choice) {
            case 1:
                guestController.showMenu();
                break;
            case 2:
                passportController.showMenu();
                break;
            case 3:
                roomController.showMenu();
                break;
            case 4:
                return;
            default:
                System.out.println("Ошибка выбора. Пожалуйста, попробуйте снова.");
        }
    }
}
