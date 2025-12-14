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

}