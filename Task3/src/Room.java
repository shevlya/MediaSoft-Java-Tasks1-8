public abstract class Room {
    private int numberOfRoom;
    private int maxCountPeopleOfRoom;
    private int priceOneNight;
    private boolean bookRoom;

    public Room (int numberOfRoom, int maxCountPeopleOfRoom, int priceOneNight){
        this.numberOfRoom = numberOfRoom;
        this.maxCountPeopleOfRoom = maxCountPeopleOfRoom;
        this.priceOneNight = priceOneNight;
        this.bookRoom = false;
    }

    public Room(int numberOfRoom, Prices price){
        this.numberOfRoom = numberOfRoom;
        this.maxCountPeopleOfRoom = (int)(Math.random() * 4 + 1);
        this.priceOneNight = price.getValue();
        this.bookRoom = false;
    }

    public boolean isBookRoom(){
        return bookRoom;
    }
    public void setBookRoom(boolean bookRoomYet){
        bookRoom = bookRoomYet;
    }
    public int getNumberOfRoom(){
        return numberOfRoom;
    }

    @Override
    public String toString(){
        String className = getClass().getSimpleName();
        String text = className + " № " + numberOfRoom + ", максимум человек: " + maxCountPeopleOfRoom + ", цена: " + priceOneNight + ", забронирована: " + bookRoom;
        return text;
    }
}
