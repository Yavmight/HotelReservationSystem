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

    private static final String RES_CSV = "reservations.csv";

    public Hotel(String hotelName, String hotelLocation, int buildingStories, double vatRate) {
        this.hotelName = hotelName;
        this.hotelLocation = hotelLocation;
        this.buildingStories = buildingStories;
        this.vatRate = vatRate;
    }

    // ===== Getters =====
    public String getHotelName() { return hotelName; }
    public String getHotelLocation() { return hotelLocation; }
    public int getBuildingStories() { return buildingStories; }
    public double getVatRate() { return vatRate; }

    // ===== Setters =====
    public void setHotelName(String hotelName) { this.hotelName = hotelName; }
    public void setHotelLocation(String hotelLocation) { this.hotelLocation = hotelLocation; }
    public void setBuildingStories(int buildingStories) { this.buildingStories = buildingStories; }
    public void setVatRate(double vatRate) { this.vatRate = vatRate; }

    // ===== Rooms =====
    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room findRoomByNumber(int roomNum) {
        for (Room r : rooms) {
            if (r.getRoomNum() == roomNum) return r;
        }
        return null;
    }

    public List<Room> getAvailableRooms() {
        List<Room> available = new ArrayList<>();
        for (Room r : rooms) {
            if (r.isAvailable()) available.add(r);
        }
        return available;
    }

    // ===== Reservations (In-Memory) =====
    public Reservation findReservationById(String reservationId) {
        for (Reservation r : reservations) {
            if (r.getReservationId().equalsIgnoreCase(reservationId)) return r;
        }
        return null;
    }

    public List<Reservation> getAllReservations() {
        return new ArrayList<>(reservations);
    }

    // ===== Booking =====
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

        // in-memory
        reservations.add(reservation);

        // CSV (Option A: log/persist)
        saveReservationToCsv(reservation);

        return reservation;
    }

    // ===== Cancel =====
    public boolean cancelReservation(String reservationId) {
        Reservation r = findReservationById(reservationId);
        if (r == null) return false;

        r.getRoom().release();
        reservations.remove(r);

        // CSV (Option A)
        deleteReservationFromCsv(reservationId);

        return true;
    }

    // ===== CSV Methods =====
    public void saveReservationToCsv(Reservation r) {
        CsvCrud.create(RES_CSV, r.toCsvLine());
    }

    public void deleteReservationFromCsv(String reservationId) {
        CsvCrud.delete(RES_CSV, reservationId);
    }

    public void printReservationFromCsv(String reservationId) {
        String line = CsvCrud.readById(RES_CSV, reservationId);
        if (line == null) {
            System.out.println("Reservation not found in CSV.");
            return;
        }
        System.out.println("=== RESERVATION FROM CSV ===");
        System.out.println(line);
    }

    public void printAllReservationsFromCsv() {
        List<String> lines = CsvCrud.readAll(RES_CSV);
        if (lines.isEmpty()) {
            System.out.println("CSV is empty.");
            return;
        }
        System.out.println("=== ALL RESERVATIONS FROM CSV ===");
        for (String l : lines) {
            System.out.println(l);
        }
    }
}