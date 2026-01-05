public class StandardRoom extends Room {
    private double baseRoomPrice;

    public StandardRoom(int roomNum, double roomPrice, boolean isOccupied, double serviceFee, double baseRoomPrice) {
        super(roomNum, roomPrice, isOccupied);
        this.baseRoomPrice = baseRoomPrice;
    }

    public double getBaseRoomPrice() {
        return baseRoomPrice;
    }

    public void setBaseRoomPrice(double baseRoomPrice) {
        this.baseRoomPrice = baseRoomPrice;
    }


    public double calculatePrice(int nights, double vatRate) {
        double subtotal = getBaseRoomPrice() * nights;
        return subtotal + (subtotal * vatRate);
    }

}