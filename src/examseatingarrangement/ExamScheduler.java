package examseatingarrangement;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamScheduler {
    private List<Exam> exams;
    private ExamHall examHall;
    private Connection connection;

    public ExamScheduler(ExamHall examHall, Connection connection) {
        this.exams = new ArrayList<>();
        this.examHall = examHall;
        this.connection = connection;
    }

    public void addExam(Exam exam) {
        exams.add(exam);
    }
    public void generateSchedule() {
    for (Exam exam : exams) {
        System.out.println("Exam: " + exam.getName());

        List<Student> students = exam.getStudents();
        SeatingArrangement seatingArrangement = new SeatingArrangement(examHall);

        if (students.isEmpty()) {
            System.out.println("No students registered for the exam.");
            continue;
        }

        System.out.println("Total students registered: " + students.size());

        for (Student student : students) {
            Seat seat = examHall.allocateSeat();
            if (seat != null) {
                System.out.println("Assigned seat - Student: " + student.getName() + ", Seat: " + seat.getSeatNumber());
                seatingArrangement.assignSeat(student, seat);
            } else {
                System.out.println("No available seats for student: " + student.getName());
            }
        }

        exam.setSeatingArrangement(seatingArrangement);
    }
    }
    public SeatingArrangement getSeatingArrangement(Exam exam) {
        for (Exam e : exams) {
            if (e.getId() == exam.getId()) {
                return e.getSeatingArrangement();
            }
        }
        return null;
    }
}
