package com.bluescopeJsons;
import java.sql.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonExampleMySQL {

    public static void main(String[] args) throws SQLException {
        // MySQL connection details
        String url = "jdbc:mysql://localhost:3306/finezoom"; // Adjust the database URL
        String user = "root"; // Replace with your MySQL username
        String password = "Msdkishore@01"; // Replace with your MySQL password

        // Establishing connection
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a table with a JSON column
        Statement stmt = con.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS fruit (id INT AUTO_INCREMENT PRIMARY KEY, data JSON)");

        // Insert a JSON object into the table
        stmt.executeUpdate("INSERT INTO fruit (data) VALUES ('{\"name\":\"pear\",\"count\":10}')");

        // Create another JSON object
        JsonObject orange = new JsonObject();
        orange.addProperty("name", "orange");
        orange.addProperty("count", 12);

        // Insert the orange JSON object
        PreparedStatement pstmt = con.prepareStatement("INSERT INTO fruit (data) VALUES (?)");
        pstmt.setString(1, orange.toString());
        pstmt.executeUpdate();
        pstmt.close();

        // Select the pear JSON object
        ResultSet rs = stmt.executeQuery("SELECT data FROM fruit WHERE JSON_UNQUOTE(JSON_EXTRACT(data, '$.name')) = 'pear'");
        rs.next();
        String pearData = rs.getString("data");

        // Parse the JSON data and modify it
        JsonObject pear = JsonParser.parseString(pearData).getAsJsonObject();
        int count = pear.get("count").getAsInt();
        pear.addProperty("count", count + 1);
        pear.addProperty("color", "green");

        // Update the pear JSON object in the database
        pstmt = con.prepareStatement("UPDATE fruit SET data = ? WHERE JSON_UNQUOTE(JSON_EXTRACT(data, '$.name')) = 'pear'");
        pstmt.setString(1, pear.toString());
        pstmt.executeUpdate();
        pstmt.close();

        // Close resources
        rs.close();
        stmt.close();
        con.close();
    }
}