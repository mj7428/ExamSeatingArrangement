
package examseatingarrangement;

import java.util.HashMap;
import java.util.Map;

public class SeatingArrangement {
    private ExamHall examHall;
    private Map<Seat, Student> assignedSeats;

    public SeatingArrangement(ExamHall examHall) {
        this.examHall = examHall;
        this.assignedSeats = new HashMap<>();
    }

    public void assignSeat(Student student, Seat seat) {
        assignedSeats.put(seat, student);
    }

    public Map<Seat, Student> getAssignedSeats() {
        return assignedSeats;
        }
    
}


