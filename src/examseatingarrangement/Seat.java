
package examseatingarrangement;


public class Seat {
    private int seatNumber;
    private boolean isAvailable;
    
    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isAvailable = true;
    }
    
    public int getSeatNumber() {
        return seatNumber;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

