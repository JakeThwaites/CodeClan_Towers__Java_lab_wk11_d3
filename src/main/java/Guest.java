public class Guest {
    private Boolean isCheckedIn;
    private Integer wallet;

    public Guest(Integer wallet){
        this.isCheckedIn = false;
        this.wallet = wallet;
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

    public int moneyInWallet(){
        return wallet;
    }

    public void buyDrink(Bar bar){
        if(moneyInWallet() >= 5 && bar.drinksRemaining() > 0){
            wallet -= 5;
            bar.sellDrink();
        }
    }
}
