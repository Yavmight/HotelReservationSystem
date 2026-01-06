import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private String hotelName;
    private String hotelLocation;
    private int buildingStories;

    private double vatRate;

    private final List<Room> rooms = new ArrayList<>();
    private final List<Reservation> reservations = new ArrayList<>();

    private int reservationCounter = 1;

    public Hotel(String hotelName, String hotelLocation, int buildingStories, double vatRate) {
        this.hotelName = hotelName;
        this.hotelLocation = hotelLocation;
        this.buildingStories = buildingStories;
        this.vatRate = vatRate;
    }


    public String getHotelName() {
        return hotelName;
    }

    public String getHotelLocation() {
        return hotelLocation;

    }

    public int getBuildingStories() {
        return buildingStories;
    }

    public double getVatRate() {
        return vatRate;
    }


    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }

    public void setBuildingStories(int buildingStories) {
        this.buildingStories = buildingStories;

    }

    public void setVatRate(double vatRate) {
        this.vatRate = vatRate;
    }


    public void addRoom(Room room) {
        rooms.add(room);
    }


    public List<Room> getAvailableRooms() {
        List<Room> available = new ArrayList<>();
        for (Room r : rooms) {
            if (r.isAvailable()) available.add(r);
        }
        return available;
    }

    public Room findRoomByNumber(int roomNum) {
        for (Room r : rooms) {
            if (r.getRoomNum() == roomNum) return r;
        }
        return null;
    }


    public Reservation bookRoom(Customer customer, int roomNum, LocalDate checkIn, int nights, Payment.PaymentMethod method) {
        if (nights <= 0) throw new IllegalArgumentException("Nights must be >= 1");
        Room room = findRoomByNumber(roomNum);
        if (room == null) throw new IllegalArgumentException("Room not found.");
        if (!room.isAvailable()) throw new IllegalStateException("Room is not available.");

        double total = room.calculatePrice(nights, vatRate);

        Payment payment = new Payment(method, total);
        payment.pay();

        room.reserve();

        String reservationId = "R" + reservationCounter++;
        Reservation reservation = new Reservation(reservationId, customer, room, checkIn, nights, payment);
        reservations.add(reservation);

        return reservation;
    }


    public boolean cancelReservation(String reservationId) {
        Reservation r = findReservationById(reservationId);
        if (r == null) return false;

        r.getRoom().release();
        reservations.remove(r);
        return true;
    }

    // View booking details
    public Reservation findReservationById(String reservationId) {
        for (Reservation r : reservations) {
            if (r.getReservationId().equalsIgnoreCase(reservationId)) return r;

        }
        return null;
    }

    public List<Reservation> getAllReservations() {
        return new ArrayList<>(reservations);
    }
}