import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {
    Guest guest;
    Bedroom room1;

    @Before
    public void before(){
        guest = new Guest();
        room1 = new Bedroom(1, 1, "Single");
    }

    @Test
    public void guestStartsNotCheckedIn(){
        assertEquals(false, guest.checkInStatus());
    }

    @Test
    public void canCheckIn(){
        assertEquals(false, guest.checkInStatus());
        guest.checkIn();
        assertEquals(true, guest.checkInStatus());
    }

    @Test
    public void bedroomAddGuestUpdatesStatus(){
        assertEquals(false, guest.checkInStatus());
        room1.addGuest(guest);
        assertEquals(true, guest.checkInStatus());
    }

    @Test
    public void canCheckOut(){
        room1.addGuest(guest);
        assertEquals(true, guest.checkInStatus());
        guest.checkOut();
        assertEquals(false, guest.checkInStatus());
    }

    @Test
    public void removeGuestUpdatesStatus(){
        room1.addGuest(guest);
        assertEquals(true, guest.checkInStatus());
        room1.removeGuests();
        assertEquals(false, guest.checkInStatus());
    }
}
