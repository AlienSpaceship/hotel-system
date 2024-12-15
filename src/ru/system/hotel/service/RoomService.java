package ru.system.hotel.service;

import ru.system.hotel.model.Room;
import ru.system.hotel.model.Type;

import java.util.Iterator;

import static ru.system.hotel.database.Database.roomList;

public class RoomService {

    public void addToDatabase(String number, Type roomType, boolean isAvailable) {
        Room room = new Room(number, roomType, isAvailable);
        roomList.add(room);
        System.out.println("Комната добавлена");
    }

    public void deleteFromDatabase(String number) {
        boolean success = false;
        Iterator<Room> iterator = roomList.iterator();

        while (iterator.hasNext()) {
            Room n = iterator.next();
            if (n.getNumber().equals(number)) {
                iterator.remove();
                success = true;
                break;
            }
        }
        if (success) {
            System.out.println("Комната с номером " + number + " удалена");
        } else {
            System.out.println("Ошибка: Комната с номером " + number + " не существует");
        }
    }

    public void listRooms() {
        System.out.println("Список комнат:");
        for (Room room : roomList) {
            System.out.print("Номер: " + room.getNumber() + ", Тип: " + room.getRoomType() + ", Свободна: ");
            if (room.isAvailable()) {
                System.out.println("Да");
            } else System.out.println("Нет");
        }
    }

}
