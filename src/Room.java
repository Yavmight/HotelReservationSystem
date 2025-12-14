public class Room {
    private int roomNum;
    private double roomPrice;
    private double VAT;
    private boolean isOccupied;

     public Room(int roomNum, double roomPrice, boolean isOccupied) {
        this.roomNum = roomNum;
        this.roomPrice = roomPrice;
        this.isOccupied = isOccupied;
    }

    //add getters
    public int getRoomNum() {
        return roomNum;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public double getVAT() {
        return VAT;
    }

    public boolean IsOccupied() {
        return isOccupied;
    }

    
    //add setters
    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public void setVAT(double VAT) {
        this.VAT = VAT;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

}