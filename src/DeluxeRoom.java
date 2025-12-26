
public class DeluxeRoom extends Room {

    private double serviceFee;

    public DeluxeRoom(int roomNum, double roomPrice, boolean isOccupied, double serviceFee) {
        super(roomNum, roomPrice, isOccupied);
        this.serviceFee = serviceFee;
    }

    public double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }

    @Override
    public double calculatePrice() {
        return super.calculatePrice() + serviceFee;
    }
}