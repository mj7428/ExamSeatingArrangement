
package examseatingarrangement;

import java.util.ArrayList;
import java.util.List;

public class Exam {
    private int id;
    private String name;
    private List<Student> students;
    private SeatingArrangement seatingArrangement;

    public Exam(int id, String name) {
        this.id = id;
        this.name = name;
        this.students = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public SeatingArrangement getSeatingArrangement() {
        return seatingArrangement;
    }

    public void setSeatingArrangement(SeatingArrangement seatingArrangement) {
        this.seatingArrangement = seatingArrangement;
    }
}

