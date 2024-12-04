package information;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentOperations {

    // Create a new student record2
	public String insertStudent(String name, int age, String gender, Date dob, String department, String email) {
        String insertQuery = "INSERT INTO students (name, age, gender, department, email) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionsJdbc.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, gender);
            //pstmt.setDate(4, dob);
            pstmt.setString(4, department);
            pstmt.setString(5, email);

            int rowsInserted = pstmt.executeUpdate();
//            System.out.println("Rows inserted: " + rowsInserted);
            return rowsInserted > 0 ? "students added successfully!" : "Failed to add students.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
		
		
    }

    // Read all student records
    public String fetchAllStudents() {
    	try (Connection conn = ConnectionsJdbc.getConnection()) {
            String sql = "SELECT * FROM students";
            PreparedStatement s = conn.prepareStatement(sql);
            ResultSet rs = s.executeQuery();
            StringBuilder r = new StringBuilder();
            r.append("<table border='1' style='width:100%; text-align:center;'>")
            .append("<tr>")
            .append("<th>ID</th>")
            .append("<th>Name</th>")
            .append("<th>Age</th>")
            .append("<th>Gender</th>")
            .append("<th>Email</th>")
            .append("<th>Actions</th>")
            .append("</tr>");
            while (rs.next()) {
            	int id = rs.getInt("student_id");
                r.append("<tr>")
                 .append("<td>").append(id).append("</td>")
                 .append("<td>").append(rs.getString("name")).append("</td>")
                 .append("<td>").append(rs.getInt("age")).append("</td>")
                 .append("<td>").append(rs.getString("gender")).append("</td>")
                 .append("<td>").append(rs.getString("department")).append("</td>")
                 .append("<td>").append(rs.getString("email")).append("</td>")
                 .append("<td>")
                 .append("<form action='status2.html' style='display:inline;'>")
                 //.append("<input type='hidden' name='action' value='update'>")
                 //.append("<input type='hidden' name='id' value='").append(id).append("'>")
                 //.append("<input type='text' name='newDepartment' placeholder='New Department' required>")
                 .append("<button type='submit'>Update</button>")
                 .append("</form>")
                 .append("<form action='delete-students' method='post' style='display:inline;'>")
                 .append("<input type='hidden' name='action' value='delete'>")
                 .append("<input type='hidden' name='studentId' value='").append(id).append("'>")
                 .append("<button type='submit'>Delete</button>")
                 .append("</form>")

                 .append("</td>")
                 .append("</tr>");
            }
                 r.append("</table>")
                 .append("<br><br>")
                 .append("<form action='status3.html' style='display:inline;'>")
                 .append("<button type='submit'>Add</button>")
                 .append("</form>")
                 .append("      ")
                 .append("<form action='status.html' style='display:inline;'>")
                 .append("<button type='submit'>Home</button>")
                 .append("</form>");
                 
            	
//                r.append("ID: ").append(rs.getInt("student_id"))
//                      .append(", Name: ").append(rs.getString("name"))
//                      .append(", Age: ").append(rs.getInt("age"))
//                      .append(", Gender: ").append(rs.getString("gender"))
//                      //.append(", Date Of Birth: ") .append(rs.getDate("date_of_birth")) 
//                      .append(", Department: ").append(rs.getString("department"))
//                      .append(", Email: ").append(rs.getString("email"))
//                      .append("<br>");
            
            return r.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    // Update a student record
    public String updateStudentDepartment(int studentId, String newDepartment) {
        String updateQuery = "UPDATE students SET department = ? WHERE student_id = ?";
        try (Connection conn = ConnectionsJdbc.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

            pstmt.setString(1, newDepartment);
            pstmt.setInt(2, studentId);

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0 ? "studentDetails added successfully!" : "Failed to add students.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    // Delete a student record
    public String deleteStudent(int studentId) {
        String deleteQuery = "DELETE FROM students WHERE student_id = ?";
        try (Connection conn = ConnectionsJdbc.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {

            pstmt.setInt(1, studentId);

            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0 ? "StudentDetails deleted successfully!" : "Failed to delete fruit.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
