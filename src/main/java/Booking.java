public class Booking {
    private Bedroom bedroom;
    private Integer numberOfNights;

    public Booking(Bedroom bedroom, Integer numberOfNights){
        this.bedroom = bedroom;
        this.numberOfNights = numberOfNights;
    }

    public int numberOfNights(){
        return numberOfNights;
    }

    public Bedroom bedroom(){
        return bedroom;
    }

    public int totalBill(){
        return bedroom.getNightlyRate() * numberOfNights;
    }
}
