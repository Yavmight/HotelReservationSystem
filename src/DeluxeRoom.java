public class DeluxeRoom extends Room {

    private double basePrice;
    private double deluxeFee;

    public DeluxeRoom(int roomNum, double basePrice, double deluxeFee) {
        super(roomNum);
        this.basePrice = basePrice;
        this.deluxeFee = deluxeFee;
    }

    public double getDeluxeFee() {
        return deluxeFee;
    }

    public void setDeluxeFee(double deluxeFee) {
        this.deluxeFee = deluxeFee;
    }

    @Override
    public double calculatePrice(int nights, double vatRate) {
        double subtotal = (basePrice + deluxeFee) * nights;
        return subtotal + (subtotal * vatRate);
    }

    @Override
    public String getRoomType() {
        return "Deluxe";
    }
}   