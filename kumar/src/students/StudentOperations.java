package students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentOperations {

    // Create a new student record2
    public void insertStudent(String name, int age, String gender, String department, String email) {
        String insertQuery = "INSERT INTO students (name, age, gender, department, email) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = (Connection) ConnectionsJdbc.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, gender);
            pstmt.setString(4, department);
            pstmt.setString(5, email);

            int rowsInserted = pstmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read all student records
    public void fetchAllStudents() {
        String selectQuery = "SELECT * FROM students";
        try (Connection conn = (Connection) ConnectionsJdbc.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectQuery)) {

            System.out.println("Student Records:");
            while (rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("student_id") +
                    ", Name: " + rs.getString("name") +
                    ", Age: " + rs.getInt("age") +
                    ", Gender: " + rs.getString("gender") +
                    ", Department: " + rs.getString("department") +
                    ", Email: " + rs.getString("email")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update a student record
    public void updateStudentDepartment(int studentId, String newDepartment) {
        String updateQuery = "UPDATE students SET department = ? WHERE student_id = ?";
        try (Connection conn = (Connection) ConnectionsJdbc.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

            pstmt.setString(1, newDepartment);
            pstmt.setInt(2, studentId);

            int rowsUpdated = pstmt.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete a student record
    public void deleteStudent(int studentId) {
        String deleteQuery = "DELETE FROM students WHERE student_id = ?";
        try (Connection conn = (Connection) ConnectionsJdbc.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {

            pstmt.setInt(1, studentId);

            int rowsDeleted = pstmt.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
