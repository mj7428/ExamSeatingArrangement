
package examseatingarrangement;

import java.util.ArrayList;
import java.util.List;

public class ExamHall {
    private List<Seat> seats;
    private int nextSeatNumber;
    private int totalSeats;
    private List<Seat> availableSeats;
    
    public ExamHall(int totalSeats) {
        seats = new ArrayList<>();
        nextSeatNumber = 1;
        for (int i = 1; i <= totalSeats; i++) {
            seats.add(new Seat(i));
        }
        this.totalSeats = totalSeats;
        this.availableSeats = new ArrayList<>();
        initializeSeats();
    }
    
    private void initializeSeats() {
        for (int i = 1; i <= totalSeats; i++) {
            availableSeats.add(new Seat(i));
        }
    }
    
    public Seat assignSeat(Student student) {
        for (Seat seat : availableSeats) {
            if (seat.isAvailable()) {
                int row = (nextSeatNumber - 1) / 10; // Assuming 10 seats per row
                int seatInRow = (nextSeatNumber - 1) % 10 + 1;
                seat = availableSeats.get(nextSeatNumber - 1);
                seat.setAvailable(false);
                student.setSeat(seat);
                availableSeats.remove(nextSeatNumber - 1);
                nextSeatNumber++;
                return seat;
            }
        }
        return null; // No available seats
    }
    
    public boolean isSeatAvailable() {
        for (Seat seat : availableSeats) {
            if (seat.isAvailable()) {
                return true;
            }
        }
        return false;
    }
    public Seat allocateSeat() {
        if (nextSeatNumber <= seats.size()) {
            Seat allocatedSeat = seats.get(nextSeatNumber - 1);
            nextSeatNumber++;
            return allocatedSeat;
        }
        return null;
    }
}

