import java.util.ArrayList;

public class Bedroom {
    private Integer number;
    private Integer capacity;
    private ArrayList<Guest> guests;
    private String type;

    public Bedroom(Integer number, Integer capacity, String type){
        this.number = number;
        this.capacity = capacity;
        this.type = type;
        this.guests = new ArrayList<>();
    }

    public int getNumber(){
        return number;
    }

    public int numberOfGuests(){
        return guests.size();
    }

    public void addGuest(Guest guest){
        guests.add(guest);
        guest.checkIn();
    }

    public int getCapacity(){
        return capacity;
    }

    public String getType(){
        return type;
    }

    public void removeGuests(){
        guests.clear();
        for (int i = 0; i < guests.size(); i++ ){
            guests.get(i).checkOut();
        }
    }


}
