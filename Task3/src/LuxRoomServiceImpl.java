public class LuxRoomServiceImpl <T extends LuxRoom> implements LuxRoomService<T>{
    @Override
    public void clean(T room){
        System.out.print("Уборка LUX " + room);
    }

    @Override
    public void reserve(T room){
        if(room.isBookRoom()) throw new RoomReadyReserveException("Комната " + room.getNumberOfRoom() + " уже зарезервирована");
        room.setBookRoom(true);
        System.out.println("LUX комната занята: " + room);
    }

    @Override
    public void free(T room){
        room.setBookRoom(false);
        System.out.println("LUX комната свободна: " + room);
    }

    @Override
    public void foodDelivery(T room){
        System.out.println("Заказ еды: " + room);
    }
}
