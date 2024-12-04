package finezone;

import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.Scanner;

//import project.CSVToData;
//import project.QueryToFile;

public class Main {
	     public static void main(String[] args) throws Exception {
//		 String csvFilePath = "D:\\Sample\\project.csv"; // Path to your CSV file
//	        String query = "SELECT * FROM bluescope"; // Your query
//	        String outputFilePath = "D:\\Sample\\project.txt"; // Output file path
//		 CSVToData csvLoader = new CSVToData();
//	        csvLoader.loadCSVToDatabase(csvFilePath);
//
//	        QueryToFile queryExecutor = new QueryToFile();
//	        queryExecutor.executeQueryAndWriteToFile(query, outputFilePath);

	    	Scanner s = new Scanner(System.in);

	    	int choice;

	    	do {

	    		System.out.println("Wellcome to my company");

	    		System.out.println("1.Adding a new employee");

	    		System.out.println("2.Retrieving all an employee");

	    		System.out.println("3.Retrieving an employee by ID");

	    		System.out.println("4.Updating employee details");

	    		System.out.println("5.Deleting an employee");

	    		System.out.println("6.Count the total employee");

	    		System.out.println("7.Sort by employee name");
	    		
	    		System.out.println("8.Read The File");

	    		System.out.println("9.Exit");

	    		System.out.println("Enter Your choice");

	    		choice = s.nextInt();

	    		switch (choice) {

				case 1: {

					System.out.println("Enter the employee name");

					String name= s.next();

					System.out.println("Enter the employee age");

					int age = s.nextInt();

					System.out.println("Enter the employee department");

					String role = s.next();				

					 Employee emp1 = new Employee(name,age,role);

					 emp1.addEmployee();

					 System.out.println("");

					 Thread.sleep(1000);

					 break;

				}

				case 2:{

					String emp = Employee.getAllEmployees();

			        if (emp != null) {

			            System.out.println(emp);

			        }

			        System.out.println("");

			        Thread.sleep(1000);

					 break;

				}

				case 3:{

					System.out.println("Enter the employee id: ");

					int id =s.nextInt();

					Employee emp = Employee.getEmployeeById(id);

			        if (emp != null) {

			            System.out.println(emp);

			        }

			        System.out.println("");

			        Thread.sleep(1000);

					 break;

				}

				case 4:{

					System.out.println("Enter the employee id: ");

					int id =s.nextInt();

					System.out.println("Enter the employee name: ");

					String name= s.next();

					System.out.println("Enter the employee age: ");

					int age = s.nextInt();

					System.out.println("Enter the employee role: ");

					String role = s.next();				

					 Employee emp1 = new Employee(id,name,age,role);

					 emp1.updateEmployee();

					 System.out.println("");

					 Thread.sleep(1000);

					 break;

				}

				case 5:{

					System.out.println("Enter the employee id: ");

					int id =s.nextInt();

					Employee.deleteEmployee(id);

					System.out.println("");

				}

				System.out.println("");

				Thread.sleep(1000);

				break;

				case 6:{

					try (Connection conn = ConnectionsJdbc.getConnection();){

							Statement stmt= conn.createStatement();

							ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM bluescope");

				            rs.next();

				                int count = rs.getInt(1);

				                System.out.println("Number of employee: " + count);

				                conn.close();

				} catch (SQLException e) {

					e.printStackTrace();

				}

					System.out.println("");

					Thread.sleep(1000);

					break;

				}

				case 7 :{

					try (Connection conn = ConnectionsJdbc.getConnection();){

						Statement stmt= conn.createStatement();

						stmt.execute("select name from bluescope order by name");

					ResultSet rs = stmt.getResultSet();

					System.out.println("order by name :");

				        while (rs.next()) {

				                

				                System.out.println(rs.getString("name"));

				        } 

				        conn.close();

					} catch (SQLException e) {

						e.printStackTrace();

					}

					System.out.println("");

					Thread.sleep(1000);

					break;

				}

				

				case 8: {
					String csvFilePath = "D:\\Sample\\project.csv"; // Path to your CSV file
			        String query = "SELECT * FROM bluescope"; // Your query
			        String outputFilePath = "D:\\Sample\\project.txt"; // Output file path
			        CSVToData csvLoader = new CSVToData();
			        csvLoader.loadCSVToDatabase(csvFilePath);

			        QueryToFile queryExecutor = new QueryToFile();
			        queryExecutor.executeQueryAndWriteToFile(query, outputFilePath);

//					System.out.println("");

//					System.exit(0);
			        break;

				}

				case 9: {
					System.out.println("Exit.,....");
					System.out.println("");

					System.exit(0);

				}

				default:

					throw new IllegalArgumentException("Unexpected value: " + choice);

				}

	    	}while(true);

	    	

	    }
	 

	}


