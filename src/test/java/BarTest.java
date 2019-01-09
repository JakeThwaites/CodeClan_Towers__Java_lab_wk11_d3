import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BarTest {
    private Bar bar;
    private Guest guest1;
    private Guest guest2;
    private Guest guest3;

    @Before
    public void before(){
        bar = new Bar(2, 20);
        guest1 = new Guest(10);
        guest2 = new Guest(10);
        guest3 = new Guest(10);
    }

    @Test
    public void hasCapacity(){
        assertEquals(2, bar.getCapacity());
    }

    @Test
    public void canAddGuest(){
        assertEquals(0, bar.totalGuests());
        bar.addGuest(guest1);
        assertEquals(1, bar.totalGuests());
    }

    @Test
    public void cannotAddMoreGuestsThanCapacity(){
        assertEquals(0, bar.totalGuests());
        bar.addGuest(guest1);
        bar.addGuest(guest2);
        bar.addGuest(guest3);
        assertEquals(2, bar.totalGuests());
    }

    @Test
    public void canRemoveGuest(){
        bar.addGuest(guest1);
        assertEquals(1, bar.totalGuests());
        bar.removeGuest(guest1);
        assertEquals(0, bar.totalGuests());
    }

    @Test
    public void hasDrinks(){
        assertEquals(20, bar.drinksRemaining());
    }

    @Test
    public void canSellDrink(){
        assertEquals(20, bar.drinksRemaining());
        bar.sellDrink();
        assertEquals(19, bar.drinksRemaining());
    }
}
