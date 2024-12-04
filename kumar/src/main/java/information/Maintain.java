package information;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

//@WebServlet("/StudentServlet")
public class Maintain extends HttpServlet {

    private StudentOperations studentOps = new StudentOperations();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String r="";
        try {
            if ("insert".equals(action)) {
                // Insert a student
                String name = request.getParameter("name");
                int age = Integer.parseInt(request.getParameter("age"));
                String gender = request.getParameter("gender");
               // Date date = Date.valueOf(request.getParameter("date_of_birth"));
                String department = request.getParameter("department");
                String email = request.getParameter("email");

                r=studentOps.insertStudent(name, age, gender, null, department, email);
                r = studentOps.fetchAllStudents();

            } else if ("update".equals(action)) {
                // Update a student
                int studentId = Integer.parseInt(request.getParameter("studentId"));
                String newDepartment = request.getParameter("newDepartment");

               r= studentOps.updateStudentDepartment(studentId, newDepartment);
               r="Student updated successfully!";
               r = studentOps.fetchAllStudents();

            } else if ("delete".equals(action)) {
                // Delete a student
                int studentId = Integer.parseInt(request.getParameter("studentId"));
                System.out.println(studentId);
                studentOps.deleteStudent(studentId);
                r="StudentsDetails deleted successfully!";
                r = studentOps.fetchAllStudents();

            } else {
            	r="Invalid action!";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        response.setContentType("text/html");
        response.getWriter().write(r);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String result = "";

        if ("fetchAll".equals(action)) {
            result = studentOps.fetchAllStudents();
        } else {
            result = "Invalid action.";
        }

        response.setContentType("text/html");
        response.getWriter().write(result);
    }
}
