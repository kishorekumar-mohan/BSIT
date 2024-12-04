package learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


public class Original {
	
	
	    public void firstStudent() {
	        System.out.println("---First Student---");

	        HashMap<String, Object> Details1 = new LinkedHashMap<>();
	        Details1.put("name", "Kishore Kumar");
	        Details1.put("gender", "Male");

	        ArrayList<HashMap<String, Object>> sem_1 = new ArrayList<>();

	        // Semester 1
	        HashMap<String, Object> sem1 = new HashMap<>();
	        ArrayList<HashMap<String, Integer>> sem1Subject = new ArrayList<>();
	        HashMap<String, Integer> sem1Marks = new LinkedHashMap<>();
	        sem1Marks.put("Tamil", 83);
	        sem1Marks.put("English", 73);
	        sem1Marks.put("Maths", 65);
	        sem1Marks.put("Science", 89);
	        sem1Marks.put("Social Science", 91);
	        sem1Subject.add(sem1Marks);
	        sem1.put("Semester1", sem1Subject);
	        sem_1.add(sem1);

	        // Semester 2
	        HashMap<String, Object> sem2 = new HashMap<>();
	        ArrayList<HashMap<String, Integer>> sem2Subs = new ArrayList<>();
	        HashMap<String, Integer> sem2Marks = new LinkedHashMap<>();
	        sem2Marks.put("Tamil", 80);
	        sem2Marks.put("English", 78);
	        sem2Marks.put("Maths", 70);
	        sem2Marks.put("Science", 75);
	        sem2Marks.put("Social Science", 95);
	        sem2Subs.add(sem2Marks);
	        sem2.put("Semester2", sem2Subs);
	        sem_1.add(sem2);

	        Details1.put("marks", sem_1);
	        System.out.println(Details1);
	    }

	    public void secondStudent() {
	        System.out.println("---Second Student---");

	        HashMap<String, Object> Details2 = new LinkedHashMap<>();
	        Details2.put("name", "Gokul");
	        Details2.put("gender", "Male");

	        ArrayList<HashMap<String, Object>> sem_2 = new ArrayList<>();

	        // Semester 1
	        HashMap<String, Object> sem1 = new HashMap<>();
	        ArrayList<HashMap<String, Integer>> sem1Subject = new ArrayList<>();
	        HashMap<String, Integer> sem1Marks = new LinkedHashMap<>();
	        sem1Marks.put("Tamil", 85);
	        sem1Marks.put("English", 75);
	        sem1Marks.put("Maths", 60);
	        sem1Marks.put("Science", 80);
	        sem1Marks.put("Social Science", 75);
	        sem1Subject.add(sem1Marks);
	        sem1.put("Semester1", sem1Subject);
	        sem_2.add(sem1);

	        // Semester 2
	        HashMap<String, Object> sem2 = new HashMap<>();
	        ArrayList<HashMap<String, Integer>> sem2Subs = new ArrayList<>();
	        HashMap<String, Integer> sem2Marks = new LinkedHashMap<>();
	        sem2Marks.put("Tamil", 69);
	        sem2Marks.put("English", 75);
	        sem2Marks.put("Maths", 76);
	        sem2Marks.put("Science", 70);
	        sem2Marks.put("Social Science", 65);
	        sem2Subs.add(sem2Marks);
	        sem2.put("Semester2", sem2Subs);
	        sem_2.add(sem2);

	        Details2.put("marks", sem_2);
	        System.out.println(Details2);
	    }

	    public void fetchData() {
	        System.out.println("---Fetching Specific Data---");

	        ArrayList<HashMap<String, Object>> students = new ArrayList<>();

	        // Adding students
	        HashMap<String, Object> student1 = new LinkedHashMap<>();
	        student1.put("name", "Kishore Kumar");
	        student1.put("gender", "Male");
	        students.add(student1);

	        HashMap<String, Object> student2 = new LinkedHashMap<>();
	        student2.put("name", "Gokul");
	        student2.put("gender", "Male");
	        students.add(student2);

	        // Accessing student 2 data
	        HashMap<String, Object> msd = students.get(1);
	        String name = (String) msd.get("name");
	        System.out.println("Name: " + name);

	        // Example of fetching marks (detailed data structure handling)
	        System.out.println("\n---Marks Data---");
	        List<HashMap<String, Object>> studentMarks = (List<HashMap<String, Object>>) msd.get("marks");
	        if (studentMarks != null) {
	            HashMap<String, Object> semester1 = studentMarks.get(0); // First semester
	            List<HashMap<String, Integer>> subjects = (List<HashMap<String, Integer>>) semester1.get("Semester1");
	            HashMap<String, Integer> subjectMarks = subjects.get(0);

	            System.out.println("Science Marks: " + subjectMarks.get("Science"));
	        } else {
	            System.out.println("No marks data available.");
	        }
	    }

	    public static void main(String[] args) {
	    	Original og = new Original();
	        og.firstStudent();
	        og.secondStudent();
	        og.fetchData();
	    }
	}



