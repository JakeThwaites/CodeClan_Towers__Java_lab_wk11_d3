import java.util.ArrayList;

public class Pool {
    private int capacity;
    private ArrayList<Guest> guests;

    public Pool(int capacity){
        this.capacity = capacity;
        this.guests = new ArrayList<>();
    }

    public int getCapacity(){
        return capacity;
    }

    public int totalGuests(){
        return guests.size();
    }

    public void addGuest(Guest guest){
        if (totalGuests() < capacity && guest.checkInStatus() == true) {
            guests.add(guest);
        }
    }

    public void removeGuest(Guest guest){
        guests.remove(guest);
    }
}
