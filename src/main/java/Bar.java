import java.util.ArrayList;

public class Bar {
    private Integer capacity;
    private ArrayList<Guest> guests;
    private Integer drinks;

    public Bar(Integer capacity, Integer drinks){
        this.capacity = capacity;
        this.guests = new ArrayList<>();
        this.drinks = drinks;
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

    public int drinksRemaining(){
        return drinks;
    }

    public void sellDrink(){
        if (drinks >= 1) {
            drinks -= 1;
        }
    }
}
