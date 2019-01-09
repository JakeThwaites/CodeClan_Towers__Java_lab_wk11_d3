import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {
    private Hotel hotel;
    private Bedroom bedroom1;
    private Bedroom bedroom2;
    private Bar bar;
    private Pool pool;
    private Guest guest1;
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
        bedroom1 = new Bedroom(1,1,"Single");
        bedroom2 = new Bedroom(2, 2, "Double");
        bedrooms = new ArrayList<>();
        bedrooms.add(bedroom1);
        bedrooms.add(bedroom2);
        guest1 = new Guest();
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
}
