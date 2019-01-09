import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {
    private Hotel hotel;
    private Bedroom bedroom1;
    private Bedroom bedroom2;
    private Bar bar;
    private Pool pool;
    private Guest guest1;
    private Guest guest2;
    private ArrayList<Bedroom> bedrooms;
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
        bedroom1 = new Bedroom(1,1,"Single", 50);
        bedroom2 = new Bedroom(2, 2, "Double", 50);
        bedrooms = new ArrayList<>();
        bedrooms.add(bedroom1);
        bedrooms.add(bedroom2);
        guest1 = new Guest();
        guest2 = new Guest();
        hotel = new Hotel("Overlook Hotel", bedrooms, bars, pools);
    }

    @Test
    public void hotelHasBedrooms(){
        assertEquals(2, hotel.numberOfBedrooms());
    }

    @Test
    public void startsWithZeroGuests(){
        assertEquals(0, hotel.numberOfGuests());
    }

    @Test
    public void canCheckInGuest(){
        assertEquals(0, hotel.numberOfGuests());
        hotel.checkIn(guest1, bedroom1);
        assertEquals(1, hotel.numberOfGuests());
    }

    @Test
    public void canCheckOutGuest(){
        hotel.checkIn(guest1, bedroom1);
        assertEquals(1, hotel.numberOfGuests());
        hotel.checkOut(guest1, bedroom1);
        assertEquals(0, hotel.numberOfGuests());
    }

    @Test
    public void startsWithNoBookings(){
        assertEquals(0, hotel.numberOfBookings());
    }

    @Test
    public void canCreateBooking(){
        assertEquals(0, hotel.numberOfBookings());
        hotel.bookRoom(bedroom1, 3);
        assertEquals(1, hotel.numberOfBookings());
    }

    @Test
    public void canShowEmptyRooms(){
        hotel.checkIn(guest1, bedroom1);
        ArrayList<Bedroom> vacantRooms = hotel.showVacantRooms();
        assertEquals(1, vacantRooms.size());
    }

    @Test
    public void onlyCheckInGuestIfRoomEmpty(){
        hotel.checkIn(guest1, bedroom1);
        assertEquals(1, bedroom1.numberOfGuests());
        hotel.checkIn(guest2, bedroom1);
        assertEquals(1, bedroom1.numberOfGuests());
    }

    @Test
    public void guestCanOnlyCheckInToOneRoom(){
        assertEquals(0, bedroom2.numberOfGuests());
        hotel.checkIn(guest1, bedroom1);
        hotel.checkIn(guest1, bedroom2);
        assertEquals(1, bedroom1.numberOfGuests());
        assertEquals(0, bedroom2.numberOfGuests());
    }
}
