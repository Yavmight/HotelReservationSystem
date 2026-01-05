public abstract class Room implements Reservable {

    private int roomNum;
    private boolean isOccupied;

    public Room(int roomNum) {
        this.roomNum = roomNum;
        this.isOccupied = false;
    }


    public int getRoomNum() {
        return roomNum;
    }

    public boolean isOccupied() {
        return isOccupied;
    }


    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }


    public abstract double calculatePrice(int nights, double vatRate);

    public abstract String getRoomType();


    @Override
    public boolean isAvailable() {
        return !isOccupied;
    }

    @Override
    public void reserve() {
        if (isOccupied) {
            throw new IllegalStateException("Room already reserved.");
        }
        isOccupied = true;
    }

    @Override
    public void release() {
        isOccupied = false;
    }


    public void showRoomInfo() {
        System.out.println("----- ROOM INFO -----");
        System.out.println("Room Number : " + roomNum);
        System.out.println("Room Type   : " + getRoomType());
        System.out.println("Status      : " + (isAvailable() ? "Available" : "Occupied"));
        System.out.println("---------------------");
    }
}