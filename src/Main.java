import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Hotel hotel = new Hotel("Karradah Hotel", "Baghdad", 7, 0.20);

        hotel.addRoom(new StandardRoom(101, 80));
        hotel.addRoom(new StandardRoom(102, 90));
        hotel.addRoom(new DeluxeRoom(201, 120, 30));
        hotel.addRoom(new DeluxeRoom(202, 130, 40));

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n**** HOTEL RESERVATION SYSTEM ****");
            System.out.println("1-Search available rooms");
            System.out.println("2-Book a room");
            System.out.println("3-Cancel reservation");
            System.out.println("4-View reservation details");
            System.out.print("5-Enter reservation ID (e.g R1): \n");
            System.out.println("0-Exit");
            System.out.print("Pick a number: ");

            int choice = readInt(sc);

            try {
                switch (choice) {
                    case 1 -> searchAvailableRooms(hotel);
                    case 2 -> bookRoomFlow(hotel, sc);
                    case 3 -> cancelReservationFlow(hotel, sc);
                    case 4 -> viewReservationFlow(hotel, sc);
                    case 5 -> {
                        System.out.print("\nEnter reservation ID (example: R1): ");
                        String id = sc.nextLine();
                        hotel.printReservationFromCsv(id);
                    }
                    case 6 -> hotel.printAllReservationsFromCsv();

                    case 0 -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

     //Menu Actions

    private static void searchAvailableRooms(Hotel hotel) {
        List<Room> available = hotel.getAvailableRooms();

        if (available.isEmpty()) {
            System.out.println("No rooms available right now.");
            return;
        }

        System.out.println("\n--- AVAILABLE ROOMS ---");
        for (Room room : available) {
            room.showRoomInfo();
        }
    }

    private static void bookRoomFlow(Hotel hotel, Scanner sc) {

        System.out.println("\n--- CUSTOMER INFO ---");
        System.out.print("First name: ");
        String fname = sc.nextLine();

        System.out.print("Last name: ");
        String lname = sc.nextLine();

        System.out.print("Date of Birth (YYYY-MM-DD): ");
        LocalDate dob = LocalDate.parse(sc.nextLine());

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Phone: ");
        String phone = sc.nextLine();

        Customer customer = new Customer(fname, lname, dob, email, phone);


        System.out.println("\n--- BOOKING INFO ---");
        System.out.print("Room number: ");
        int roomNum = readInt(sc);

        System.out.print("Check-in date (YYYY-MM-DD): ");
        LocalDate checkIn = LocalDate.parse(sc.nextLine());

        System.out.print("Nights: ");
        int nights = readInt(sc);

        System.out.print("Payment method (1=CASH, 2=CARD): ");
        int pm = readInt(sc);

        Payment.PaymentMethod method = (pm == 1)
                ? Payment.PaymentMethod.CASH
                : Payment.PaymentMethod.CARD;

        Reservation reservation = hotel.bookRoom(customer, roomNum, checkIn, nights, method);

        System.out.println("\n Booking Successful!");
        reservation.ReservationDetails();

        // to print the receipts separately:
        reservation.getPayment().showReceipt();
    }

    private static void cancelReservationFlow(Hotel hotel, Scanner sc) {
        System.out.print("\nEnter reservation ID (example: R1): ");
        String id = sc.nextLine();

        boolean cancelled = hotel.cancelReservation(id);

        if (cancelled) System.out.println("Reservation cancelled successfully.");
        else System.out.println("Reservation not found.");
    }

    private static void viewReservationFlow(Hotel hotel, Scanner sc) {
        System.out.print("\nEnter reservation ID (example: R1): ");
        String id = sc.nextLine();

        Reservation res = hotel.findReservationById(id);

        if (res == null) {
            System.out.println(" Reservation not found.");
        } else {
            res.ReservationDetails();
        }
    }

    // Helper for input
    private static int readInt(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }
}
