package bluescope;

public class Main {
	 public static void main(String[] args) {
	        // Adding a new employee
	        Employee emp1 = new Employee("kishore", 21, "analysis");
	        Employee emp2 = new Employee("mani", 22, "developer");
	        Employee emp3 = new Employee("Gokul", 23, "analysis");
	        emp1.addEmployee();
	        emp2.addEmployee();
	        emp3.addEmployee();

//	        // Retrieving an employee by ID
//	        Employee emp = Employee.getEmployeeById(1);
//	        if (emp != null) {
//	            System.out.println(emp);
//	        }
//	
//	        // Updating employee details
//	        emp1 = new Employee(1, "kishore", 21, "Finance");
//	        emp1.updateEmployee();
	
	        // Deleting an employee
	        //Employee.deleteEmployee(1);
	    }
	}

