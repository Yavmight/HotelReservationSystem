import java.time.LocalDate;

public class Reservation {
    private String reservationId;
    private Customer customer;
    private Room room;
    private LocalDate checkIn;
    private int nights;
    private Payment payment;

    public Reservation(String reservationId, Customer customer, Room room, LocalDate checkIn, int nights, Payment payment) {
        this.reservationId = reservationId;
        this.customer = customer;
        this.room = room;
        this.checkIn = checkIn;
        this.nights = nights;
        this.payment = payment;
    }


    public String getReservationId() { return reservationId;
    }


    public Customer getCustomer() { return customer;
    }


    public Room getRoom() { return room;
    }


    public LocalDate getCheckIn() { return checkIn;
    }


    public int getNights() { return nights;
    }


    public Payment getPayment() { return payment;
    }


    public LocalDate getCheckOut() {
        return checkIn.plusDays(nights);
    }


    public String toCsvLine() {
        String customerName = customer.getFname() + " " + customer.getLname();

        return reservationId + "," +
                room.getRoomNum() + "," +
                room.getRoomType() + "," +
                customerName + "," +
                customer.getEmail() + "," +
                checkIn + "," +
                nights + "," +
                payment.getMethod() + "," +
                payment.getAmount() + "," +
                payment.getPaidAt();
    }

    public void ReservationDetails() {
        System.out.println("*** RESERVATION DETAILS ***");
        System.out.println("reservation ID : " + reservationId);
        System.out.println("Customer : " + customer);
        System.out.println("Room     : " + room.getRoomNum() );
        System.out.println("Check In : " + checkIn);
        System.out.println("Check Out: " + getCheckOut());
        System.out.println("Nights   : " + nights);
        System.out.println("Payment  : " + payment);
        System.out.println("***************************");
    }
}