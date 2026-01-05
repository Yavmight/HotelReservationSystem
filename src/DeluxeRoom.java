
public class DeluxeRoom extends Room {

    private double DeluxeFee;

    public DeluxeRoom(int roomNum, double roomPrice, boolean isOccupied, double serviceFee) {
        super(roomNum, roomPrice, isOccupied);
        this.DeluxeFee = serviceFee;
    }

    public double getDeluxeFee() {
        return DeluxeFee;
    }

    public void setDeluxeFee(double DeluxeFee ) {
        this.DeluxeFee = DeluxeFee;
    }


    public double calculatePrice(int nights, double vatRate) {
        double subtotal = (getRoomPrice() + getDeluxeFee()) * nights;
        return subtotal + (subtotal * vatRate);
    }
}