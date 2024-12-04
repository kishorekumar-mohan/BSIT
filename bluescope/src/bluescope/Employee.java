package bluescope;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	public class Employee {
	    private int id;
	    private String name;
	    private int age;
	    private String department;

	    public Employee(int id, String name, int age, String department) {
	        this.id = id;
	        this.name = name;
	        this.age = age;
	        this.department = department;
	    }

	    public Employee(String name, int age, String department) {
	        this.name = name;
	        this.age = age;
	        this.department = department;
	    }

	    // Method to add a new employee to the database
	    public void addEmployee() {
	        String sql = "INSERT INTO bluescope (name, age, department) VALUES (?, ?, ?)";
	        try (Connection conn = ConnectionEmp.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, name);
	            stmt.setInt(2, age);
	            stmt.setString(3, department);
	            stmt.executeUpdate();
	            System.out.println("Employee added successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Method to retrieve employee details by ID
	    public static Employee getEmployeeById(int id) {
	        String sql = "SELECT * FROM bluescope WHERE id = ?";
	        try (Connection conn = ConnectionEmp.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	        	//System.out.println(id);
	            stmt.setInt(1, id);
	            //System.out.println("**");
	            ResultSet rs = stmt.executeQuery();
	            //System.out.println("****1");
	            if (rs.next()) {
	            	//System.out.println("****000");
	                return new Employee(
	                    rs.getInt("id"), //rs-result set
	                    rs.getString("name"),
	                    rs.getInt("age"),
	                    rs.getString("department")
	                );
	            }
	            //System.out.println("****2");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    // Method to update employee details
	    public void updateEmployee() {
	        String sql = "UPDATE bluescope SET name = ?, age = ?, department = ? WHERE id = ?";
	        try (Connection conn = ConnectionEmp.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, name);
	            stmt.setInt(2, age);
	            stmt.setString(3, department);
	            stmt.setInt(4, id);
	            stmt.executeUpdate();
	            System.out.println("Employee updated successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Method to delete an employee
	    public static void deleteEmployee(int id) {
	        String sql = "DELETE FROM bluescope WHERE id = ?";
	        try (Connection conn = ConnectionEmp.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, id);
	            stmt.executeUpdate();
	            System.out.println("Employee deleted successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Getters for the employee details
	    public int getId() { return id; }
	    public String getName() { return name; }
	    public int getAge() { return age; }
	    public String getDepartment() { return department; }

	    @Override
	    public String toString() {
	        return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", department=" + department + "]";
	    }
	}


