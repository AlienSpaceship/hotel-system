package ru.system.hotel.model;

public class Room {

    private String number;

    private Type roomType;

    private boolean isAvailable;

    public Room(String number, Type roomType, boolean isAvailable) {
        this.number = number;
        this.roomType = roomType;
        this.isAvailable = isAvailable;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Type getRoomType() {
        return roomType;
    }

    public void setType(Type roomType) {
        this.roomType = roomType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
