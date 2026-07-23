public enum Prices {
    ECONOMY(200),
    STANDARD(400),
    LUX(600),
    ULTRALUX(800);

    private  final int value;
    Prices(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
