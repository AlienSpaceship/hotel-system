package ru.system.hotel.service;
import ru.system.hotel.model.Room;
import ru.system.hotel.model.Type;

import static ru.system.hotel.database.Database.roomList;

public class RoomService {

    public void addToDatabase(String number, Type roomType, boolean isAvailable){
        Room room = new Room(number, roomType, isAvailable);
        roomList.add(room);
        System.out.println("ADD ROOM...");
    }

    public void deleteFromDatabase(String number){
        for(Room n : roomList){
            if(n.getNumber().equals(number)){
                roomList.remove(n);
                System.out.println("DELETE ROOM...");
                return;
            }
        }
    }

    public void listRooms() {
        System.out.println("Список комнат:");
        for (Room room : roomList) {
            System.out.print("Номер: " + room.getNumber() + ", Тип: " + room.getRoomType() + ", Свободна: ");
            if(room.isAvailable()){
                System.out.println("Да");
            }else System.out.println("Нет");
        }
    }

}
