package ru.system.hotel;

import ru.system.hotel.controller.GuestController;
import ru.system.hotel.controller.MainController;
import ru.system.hotel.controller.PassportController;
import ru.system.hotel.controller.RoomController;
import ru.system.hotel.service.PassportService;

public class Main {
    public static void main(String[] args) {

        PassportService service = new PassportService();

        GuestController guest = new GuestController();
        PassportController passport = new PassportController(service);
        RoomController room = new RoomController();

        MainController mainController = new MainController(guest, passport, room );
        mainController.start();

    }
}

