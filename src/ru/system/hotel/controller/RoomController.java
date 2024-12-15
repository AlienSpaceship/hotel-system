package ru.system.hotel.controller;

import ru.system.hotel.model.Type;
import ru.system.hotel.service.RoomService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RoomController {
    RoomService service = new RoomService();
    Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Добавить комнату");
            System.out.println("2. Удалить комнату");
            System.out.println("3. Список комнат");
            System.out.println("4. Назад");

            int choice = 0;
            try {
                choice = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Ошибка выбора. Пожалуйста, попробуйте снова.");
                scanner.nextLine();
                showMenu();
            }

            scanner.nextLine();

            switch (choice) {
                case 1:
                    addRoom();
                    break;
                case 2:
                    deleteRoom();
                    break;
                case 3:
                    listRoom();
                    break;
                case 4:
                    System.out.println(" ");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }

    public void addRoom() {
        String number;
        Type roomType;
        boolean isAvailable;

        System.out.print("Введите номер комнаты: ");
        number = scanner.nextLine();
        while (true) {
            try {
                System.out.print("Введите тип комнаты (STANDARD, APARTMENT, PRESIDENTIAL): ");
                roomType = Type.valueOf(scanner.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Некорректный тип комнаты. Пожалуйста, попробуйте снова.");
            }
        }
        while (true) {
            try {
                System.out.print("Доступна ли комната (true/false): ");
                isAvailable = scanner.nextBoolean();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите true или false.");
                scanner.nextLine();
            }
        }
        service.addToDatabase(number, roomType, isAvailable);
    }

    public void deleteRoom() {
        String number;
        System.out.print("Введите номер комнаты который хотите удалить: ");
        number = scanner.nextLine();
        service.deleteFromDatabase(number);
    }

    public void listRoom() {
        System.out.println("--------------------");
        service.listRooms();
        System.out.println("--------------------");
    }
}
