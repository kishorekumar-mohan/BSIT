 package com.bluescopeJsons;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;

public class JsonExampleMySQLFile {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/finezoom"; // Adjust the database URL
        String user = "root"; // Replace with your MySQL username
        String password = "Msdkishore@01"; // Replace with your MySQL password

        // Input and output file paths
        String inputFilePath = "D:\\Sample\\input.json";
        String outputFilePath = "D:\\Sample\\output.json";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            // Create a table with a JSON column
            Statement stmt = con.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS fruit (id INT AUTO_INCREMENT PRIMARY KEY, data JSON)");

            // Read JSON data from the input file
            JsonArray inputArray = readJsonArrayFromFile(inputFilePath);

            // Insert JSON objects into the database
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO fruit (data) VALUES (?)");
            for (JsonElement element : inputArray) {
                pstmt.setString(1, element.toString());
                pstmt.executeUpdate();
            }
            pstmt.close();

            // Retrieve and modify data from the database
            ResultSet rs = stmt.executeQuery("SELECT data FROM fruit");
            JsonArray outputArray = new JsonArray();

            while (rs.next()) {
                String jsonData = rs.getString("data");
                JsonObject fruit = JsonParser.parseString(jsonData).getAsJsonObject();

                // Modify JSON data (e.g., increment count, add color)
                if (fruit.has("count")) {
                    int count = fruit.get("count").getAsInt();
                    fruit.addProperty("count", count + 1);
                }
                fruit.addProperty("color", "green");

                // Add modified JSON object to the output array
                outputArray.add(fruit);
            }

            // Write the output JSON array to a file
            writeJsonArrayToFile(outputArray, outputFilePath);

            // Close resources
            rs.close();
            stmt.close();

            System.out.println("Data processed and saved to: " + outputFilePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read JSON array from a file
    private static JsonArray readJsonArrayFromFile(String filePath) throws IOException {
        try (Reader reader = new FileReader(filePath)) {
            return JsonParser.parseReader(reader).getAsJsonArray();
        }
    }

    // Write JSON array to a file
    private static void writeJsonArrayToFile(JsonArray jsonArray, String filePath) throws IOException {
        try (Writer writer = new FileWriter(filePath)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(jsonArray, writer);
        }
    }
}