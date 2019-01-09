import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<Bar> bars;
    private ArrayList<Pool> pools;
    private ArrayList<Guest> guests;
    private ArrayList<Booking> bookings;

    public Hotel(String name, ArrayList<Bedroom> bedrooms, ArrayList<Bar> bars, ArrayList<Pool> pools){
        this.name = name;
        this.bedrooms = bedrooms;
        this.bars = bars;
        this.pools = pools;
        this.guests = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public int numberOfBedrooms(){
        return bedrooms.size();
    }

    public int numberOfGuests(){
        return guests.size();
    }

    public void checkIn(Guest guest, Bedroom bedroom){
        if (bedroom.checkVacancy() && guest.checkInStatus()== false) {
            bedroom.addGuest(guest);
            guests.add(guest);
        }
    }

    public void checkOut(Guest guest, Bedroom bedroom){
        bedroom.removeGuests();
        guests.remove(guest);
    }

    public int numberOfBookings(){
        return bookings.size();
    }

    public void bookRoom(Bedroom bedroom, int numberOfNights){
        Booking booking;
        booking = new Booking(bedroom, numberOfNights);
        bookings.add(booking);
    }

    public ArrayList<Bedroom> showVacantRooms(){
        ArrayList<Bedroom> vacantRooms;
        vacantRooms = new ArrayList<>();
        for (int i=0; i < bedrooms.size();  i++){
            Bedroom bedroom = bedrooms.get(i);
            if (bedroom.checkVacancy()){
                vacantRooms.add(bedroom);
            }
        }
        return vacantRooms;
    }
}
