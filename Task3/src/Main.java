public class Main {
    public static void main(String[] args) {
        RoomService<EconomyRoom> economyRoomService = new BasRoomService<>();
        EconomyRoom economyRoom = new EconomyRoom(353);
        economyRoomService.clean(economyRoom);
        economyRoomService.reserve(economyRoom);

        try {
            economyRoomService.reserve(economyRoom);
        } catch (RoomReadyReserveException e){
            System.out.println(e.getMessage());
        }

        economyRoomService.free(economyRoom);

        UltraLuxRoom ultraLuxRoom = new UltraLuxRoom(789);
        LuxRoomService<UltraLuxRoom> luxRoomService = new LuxRoomServiceImpl<>();
        luxRoomService.reserve(ultraLuxRoom);
        luxRoomService.foodDelivery(ultraLuxRoom);

        //Проверьте, что нельзя в новом сервисе заказывать доставку еды из не люксовых комнат.
        StandardRoom standardRoom = new StandardRoom(423);
        //luxRoomService.foodDelivery(standardRoom);
    }
}