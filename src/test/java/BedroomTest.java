import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {
    private Bedroom room1;
    private Guest guest1;

    @Before
    public void before(){
        room1 = new Bedroom(1, 1, "Single");
        guest1 = new Guest();
    }

    @Test
    public void roomHasNumber(){
        assertEquals(1, room1.getNumber());
    }

    @Test
    public void roomStartsWithZeroGuests(){
        assertEquals(0,room1.numberOfGuests());
    }

    @Test
    public void canAddGuest(){
        assertEquals(0, room1.numberOfGuests());
        room1.addGuest(guest1);
        assertEquals(1, room1.numberOfGuests());
    }

    @Test
    public void hasCapacity(){
        assertEquals(1, room1.getCapacity());
    }

    @Test
    public void hasType(){
        assertEquals("Single", room1.getType());
    }

    @Test
    public void canRemoveGuest(){
        room1.addGuest(guest1);
        assertEquals(1, room1.numberOfGuests());
        room1.removeGuests();
        assertEquals(0, room1.numberOfGuests());
    }


}
