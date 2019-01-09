import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookingTest {
    private Booking booking;
    private Bedroom bedroom1;

    @Before
    public void before(){
        bedroom1 = new Bedroom(1, 1, "Single", 50);
        booking = new Booking(bedroom1, 3);
    }

    @Test
    public void hasNumberOfNights(){
        assertEquals(3, booking.numberOfNights());
    }

    @Test
    public void hasBedroom(){
        assertEquals(bedroom1, booking.bedroom());
    }

    @Test
    public void canCalculateTotalBill(){
        assertEquals(150, booking.totalBill());
    }
}
