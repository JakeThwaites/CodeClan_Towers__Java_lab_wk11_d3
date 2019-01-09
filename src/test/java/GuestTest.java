import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {
    Guest guest;
    Bedroom room1;
    Bar bar;

    @Before
    public void before(){
        guest = new Guest(10);
        room1 = new Bedroom(1, 1, "Single", 50);
        bar = new Bar(10, 10);
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

    @Test
    public void hasMoney(){
        assertEquals(10, guest.moneyInWallet());
    }

    @Test
    public void buyingDrinkDecreasesMoney(){
        assertEquals(10, guest.moneyInWallet());
        assertEquals(10, bar.drinksRemaining());
        guest.buyDrink(bar);
        assertEquals(5, guest.moneyInWallet());
        assertEquals(9, bar.drinksRemaining());
    }
}
