import java.util.ArrayList;

public class Bedroom {
    private Integer number;
    private Integer capacity;
    private ArrayList<Guest> guests;
    private String type;
    private Integer nightlyRate;
    private Boolean isVacant;

    public Bedroom(Integer number, Integer capacity, String type, Integer nightlyRate){
        this.number = number;
        this.capacity = capacity;
        this.type = type;
        this.guests = new ArrayList<>();
        this.nightlyRate = nightlyRate;
        this.isVacant = true;
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
        isVacant = false;
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
        isVacant = true;
    }

    public int getNightlyRate(){
        return nightlyRate;
    }

    public Boolean checkVacancy(){
        return isVacant;
    }


}
