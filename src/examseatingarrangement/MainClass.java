
package examseatingarrangement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        // Create an instance of ConnectionClass to establish the database connection
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.con; // Assuming you have a method to get the connection
        
        // Check if the connection is successful
        if (connection != null) {
            try {
                // Create an instance of ExamHall
                ExamHall examHall = new ExamHall(100); // Specify the total number of seats in the exam hall
                
                // Create an instance of ExamScheduler
                ExamScheduler examScheduler = new ExamScheduler(examHall, connection);
                
                // Create an instance of Exam
                Exam exam = new Exam(1,"Mathematics"); // Replace with your actual exam details
                
                // Fetch student data from MySQL and populate Exam object
                String query = "SELECT id, name, department FROM student";
                ResultSet rs = connectionClass.stm.executeQuery(query);

                while (rs.next()) {
                   int id = rs.getInt("id");
                   String name = rs.getString("name");
                   String department = rs.getString("department");

                   // Create Student object and add it to the Exam object
                   Student student = new Student(id, name, department);
                   exam.addStudent(student);
                }

                // Close the ResultSet and Statement
                rs.close();
                
                // Add the exam to the scheduler
                examScheduler.addExam(exam);
                
                // Generate the seating schedule
                examScheduler.generateSchedule();
                
                // Close the connection
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to establish database connection.");
        }
    }
}

