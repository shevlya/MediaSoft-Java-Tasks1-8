public class BasRoomService <T extends Room> implements RoomService<T>{

    @Override
    public void clean(T room){
        System.out.println("Уборка " + room);
    }

    @Override
    public void reserve(T room){
        if (room.isBookRoom()) throw new RoomReadyReserveException("Комната " + room.getNumberOfRoom() + " уже зарезервирована");
        room.setBookRoom(true);
        System.out.println("Комната зарезервирована: " + room);
    }

    @Override
    public void free(T room){
        room.setBookRoom(false);
        System.out.println("Комната свободна: " + room);
    }
}
