public class StandardRoom extends Room {

    private double basePrice;

    public StandardRoom(int roomNum, double basePrice) {
        super(roomNum);
        this.basePrice = basePrice;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public double calculatePrice(int nights, double vatRate) {
        double subtotal = basePrice * nights;
        return subtotal + (subtotal * vatRate);
    }

    @Override
    public String getRoomType() {
        return "Standard";
    }
}
