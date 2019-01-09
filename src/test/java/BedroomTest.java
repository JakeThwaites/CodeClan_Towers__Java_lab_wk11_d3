import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BedroomTest {
    private Guest guest1;
    private Hotel hotel;
    private Bedroom room1;
    private Bedroom room2;
    private Bar bar;
    private Pool pool;
    private ArrayList<Bedroom> rooms;
    private ArrayList<Bar> bars;
    private ArrayList<Pool> pools;

    @Before
    public void before(){
        pool = new Pool(2);
        pools = new ArrayList<>();
        pools.add(pool);
        bar = new Bar(2);
        bars = new ArrayList<>();
        bars.add(bar);
        room1 = new Bedroom(1,1,"Single", 50);
        room2 = new Bedroom(2, 2, "Double", 50);
        rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        guest1 = new Guest();
        hotel = new Hotel("Overlook Hotel", rooms, bars, pools);
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

    @Test
    public void hasNightlyRate(){
        assertEquals(50, room1.getNightlyRate());
    }

    @Test
    public void roomStartsVacant(){
        assertEquals(true, room1.checkVacancy());
    }

    @Test
    public void bookingRoomChangesVacancy(){
        assertEquals(true, room1.checkVacancy());
        hotel.checkIn(guest1, room1);
        assertEquals(false, room1.checkVacancy());
    }


}
