package ru.system.hotel.service;
import ru.system.hotel.model.Room;
import ru.system.hotel.model.Type;

import static ru.system.hotel.database.Database.roomList;

public class RoomService {

    public boolean addToDatabase(String number, Type roomType, boolean isAvailable){
        if(number == null || roomType == null){
            System.out.println("Ошибка: Поле не заполнено");
            return false;
        }
        try{
            Room room = new Room(number, roomType, isAvailable);
            roomList.add(room);
            return false;
        }
        catch (Exception ex){
            ex.printStackTrace();
            System.out.println("Ошибка при добавлении Room: " + ex.getMessage());
            return false;
        }
    }

    public boolean deleteFromDatabase(String number){
        for(Room room : roomList){
        if(room.getNumber().equals(number)){
            roomList.remove(room);
            System.out.println("Удален: " + number);
            return true;
        }
        }
        System.out.println("Ошибка: комната " + number + " не найдена.");
        return false; // Команата с таким номером не найдена
    };
}
