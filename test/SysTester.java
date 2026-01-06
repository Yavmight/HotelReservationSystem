import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;


public class SysTester {

    @Test
    public void StandardRoompricingTest(){
        StandardRoom room = new StandardRoom(151, 100);
      double price = room.calculatePrice(3, 0.2);
       assertEquals(360.0, price);
       }


    @Test
    public void DeluxeRoomPricingTest() {
        DeluxeRoom room = new DeluxeRoom(601, 100, 50);
        double price = room.calculatePrice(2, 0.05);
        assertEquals(315.0, price);
       }

    @Test
    public void RoomReserveAndReleaseTest() {
        StandardRoom room = new StandardRoom(5, 80);
        assertTrue(room.isAvailable());
        room.reserve();
        assertFalse(room.isAvailable());
        room.release();
        assertTrue(room.isAvailable());
       }

    @Test
    public void HotelBookingTest(){
       Hotel hotel = new Hotel("Hotel Karradah", "Baghdad", 7, 0.2);
       hotel.addRoom(new StandardRoom(101, 100));
       }



    @Test
    public void HotelCancelReservationTest() {
        Hotel hotel = new Hotel("Hotel Karradah", "Baghdad", 7, 0.2);
        hotel.addRoom(new StandardRoom(101, 100));

         Customer c = new Customer("Ali", "Hassan",LocalDate.of(2000, 6, 15) , "alihassan71@gmail.com", "07852213348");
         Reservation r = hotel.bookRoom(c, 101, LocalDate.now(), 1, Payment.PaymentMethod.CARD);
          boolean cancelled = hotel.cancelReservation(r.getReservationId());
           assertTrue(cancelled);
           assertTrue(hotel.getAvailableRooms().contains(r.getRoom()));
      }

  }

