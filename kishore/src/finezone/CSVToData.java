package finezone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//import Employee;

public class CSVToData {
	 private final Employee dbOperations;

	    public CSVToData() {
	        dbOperations = new Employee();;
			//Employee ConnectionsJdbc = new Employee(0, null, 0, null);
	    }

	    public void loadCSVToDatabase(String csvFilePath) {
	        String line;
	        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
	            while ((line = br.readLine()) != null) {
	                String[] data = line.split(",");
	                int id = Integer.parseInt(data[0]);
	                String name = data[1];
	                int age = Integer.parseInt(data[2]);
	                String department = data[3];

	                dbOperations.insertEmployee(id, name, age, department);
	            }
	            System.out.println("CSV data loaded successfully.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
}

