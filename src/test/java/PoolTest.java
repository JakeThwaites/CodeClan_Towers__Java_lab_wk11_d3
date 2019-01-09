import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PoolTest {
    Pool pool;
    Guest guest1;
    Guest guest2;
    Guest guest3;

    @Before
    public void before(){
        pool = new Pool(2);
        guest1 = new Guest(10);
        guest2 = new Guest(10);
        guest3 = new Guest(10);

    }

    @Test
    public void poolHasCapacity(){
        assertEquals(2, pool.getCapacity());
    }

    @Test
    public void poolStartsWithZeroGuests(){
        assertEquals(0, pool.totalGuests());
    }

    @Test
    public void poolCanAddGuests(){
        assertEquals(0, pool.totalGuests());
        guest1.checkIn();
        pool.addGuest(guest1);
        assertEquals(1, pool.totalGuests());
    }

    @Test
    public void cannotAddMoreGuestsThanCapacity(){
        pool.addGuest(guest1);
        pool.addGuest(guest2);
        pool.addGuest(guest3);
        assertEquals(2, pool.totalGuests());
    }

    @Test
    public void canRemoveGuests(){
        pool.addGuest(guest1);
        pool.addGuest(guest2);
        assertEquals(2, pool.totalGuests());
        pool.removeGuest(guest1);
        assertEquals(1, pool.totalGuests());
    }

    @Test
    public void cannotAddGuestIfNotCheckedIn(){
        pool.addGuest(guest1);
        assertEquals(0, pool.totalGuests());
    }
}
