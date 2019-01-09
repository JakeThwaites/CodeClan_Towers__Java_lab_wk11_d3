public class Guest {
    private Boolean isCheckedIn;

    public Guest(){
        this.isCheckedIn = false;
    }

    public Boolean checkInStatus(){
        return isCheckedIn;
    }

    public void checkIn(){
        this.isCheckedIn = true;
    }

    public void checkOut(){
        isCheckedIn = false;
    }
}
