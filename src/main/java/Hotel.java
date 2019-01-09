import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<Bar> bars;
    private ArrayList<Pool> pools;
    private ArrayList<Guest> guests;

    public Hotel(String name, ArrayList<Bedroom> bedrooms, ArrayList<Bar> bars, ArrayList<Pool> pools){
        this.name = name;
        this.bedrooms = bedrooms;
        this.bars = bars;
        this.pools = pools;
        this.guests = new ArrayList<>();
    }

    public int numberOfBedrooms(){
        return bedrooms.size();
    }

    public int numberOfGuests(){
        return guests.size();
    }

    public void checkIn(Guest guest, Bedroom bedroom){
        bedroom.addGuest(guest);
        guests.add(guest);
    }

    public void checkOut(Guest guest, Bedroom bedroom){
        bedroom.removeGuests();
        guests.remove(guest);
    }
}
