import java.util.ArrayList;

public class Bar {
    private Integer capacity;
    private ArrayList<Guest> guests;

    public Bar(Integer capacity){
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
        if (totalGuests() < getCapacity()){
            guests.add(guest);
        }

    }

    public void removeGuest(Guest guest){
        guests.remove(guest);
    }
}
